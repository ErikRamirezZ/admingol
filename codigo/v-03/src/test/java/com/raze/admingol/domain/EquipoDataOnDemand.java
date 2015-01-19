package com.raze.admingol.domain;
import com.raze.admingol.catalog.StatusEquipoJugador;
import com.raze.admingol.repository.domain.EquipoRepository;
import com.raze.admingol.service.domain.EquipoService;
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
public class EquipoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Equipo> data;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    EquipoService equipoService;

	@Autowired
    EquipoRepository equipoRepository;

	public Equipo getNewTransientEquipo(int index) {
        Equipo obj = new Equipo();
        setActivo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setLogo(obj, index);
        setNombre(obj, index);
        setNombreCorto(obj, index);
        setStatus(obj, index);
        return obj;
    }

	public void setActivo(Equipo obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setFechaCreacion(Equipo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Equipo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setLogo(Equipo obj, int index) {
        byte[] logo = String.valueOf(index).getBytes();
        obj.setLogo(logo);
    }

	public void setNombre(Equipo obj, int index) {
        String nombre = "nombre_" + index;
        obj.setNombre(nombre);
    }

	public void setNombreCorto(Equipo obj, int index) {
        String nombreCorto = "nombreCorto_" + index;
        obj.setNombreCorto(nombreCorto);
    }

	public void setStatus(Equipo obj, int index) {
        StatusEquipoJugador status = StatusEquipoJugador.class.getEnumConstants()[0];
        obj.setStatus(status);
    }

	public Equipo getSpecificEquipo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Equipo obj = data.get(index);
        Long id = obj.getId();
        return equipoService.findEquipo(id);
    }

	public Equipo getRandomEquipo() {
        init();
        Equipo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return equipoService.findEquipo(id);
    }

	public boolean modifyEquipo(Equipo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = equipoService.findEquipoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Equipo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Equipo>();
        for (int i = 0; i < 10; i++) {
            Equipo obj = getNewTransientEquipo(i);
            try {
                equipoService.saveEquipo(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            equipoRepository.flush();
            data.add(obj);
        }
    }
}
