package com.raze.admingol.domain;
import com.raze.admingol.catalog.Accion;
import com.raze.admingol.repository.domain.EstadisticasRepository;
import com.raze.admingol.service.domain.EstadisticasService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class EstadisticasDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Estadisticas> data;

	@Autowired
    AlineacionDataOnDemand alineacionDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    EstadisticasService estadisticasService;

	@Autowired
    EstadisticasRepository estadisticasRepository;

	public Estadisticas getNewTransientEstadisticas(int index) {
        Estadisticas obj = new Estadisticas();
        setAccion(obj, index);
        setAlineacion(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMinuto(obj, index);
        setObservaciones(obj, index);
        return obj;
    }

	public void setAccion(Estadisticas obj, int index) {
        Accion accion = Accion.class.getEnumConstants()[0];
        obj.setAccion(accion);
    }

	public void setAlineacion(Estadisticas obj, int index) {
        Alineacion alineacion = alineacionDataOnDemand.getRandomAlineacion();
        obj.setAlineacion(alineacion);
    }

	public void setFechaCreacion(Estadisticas obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Estadisticas obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMinuto(Estadisticas obj, int index) {
        int minuto = index;
        obj.setMinuto(minuto);
    }

	public void setObservaciones(Estadisticas obj, int index) {
        String observaciones = "observaciones_" + index;
        obj.setObservaciones(observaciones);
    }

	public Estadisticas getSpecificEstadisticas(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Estadisticas obj = data.get(index);
        Long id = obj.getId();
        return estadisticasService.findEstadisticas(id);
    }

	public Estadisticas getRandomEstadisticas() {
        init();
        Estadisticas obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return estadisticasService.findEstadisticas(id);
    }

	public boolean modifyEstadisticas(Estadisticas obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = estadisticasService.findEstadisticasEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Estadisticas' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Estadisticas>();
        for (int i = 0; i < 10; i++) {
            Estadisticas obj = getNewTransientEstadisticas(i);
            try {
                estadisticasService.saveEstadisticas(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            estadisticasRepository.flush();
            data.add(obj);
        }
    }
}
