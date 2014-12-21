package com.raze.admingol.domain;
import com.raze.admingol.catalog.StatusPartido;
import com.raze.admingol.catalog.TipoPartido;
import com.raze.admingol.repository.domain.PartidoRepository;
import com.raze.admingol.service.domain.PartidoService;
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
import org.springframework.roo.addon.dod.RooDataOnDemand;
import org.springframework.stereotype.Component;

@Configurable
@Component
@RooDataOnDemand(entity = Partido.class)
public class PartidoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Partido> data;

	@Autowired
    CanchaDataOnDemand canchaDataOnDemand;

	@Autowired
    EquipoDataOnDemand equipoDataOnDemand;

	@Autowired
    HorarioDataOnDemand horarioDataOnDemand;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    PartidoService partidoService;

	@Autowired
    PartidoRepository partidoRepository;

	public Partido getNewTransientPartido(int index) {
        Partido obj = new Partido();
        setCancha(obj, index);
        setFechaCreacion(obj, index);
        setFechaJuego(obj, index);
        setFechaModificacion(obj, index);
        setStatus(obj, index);
        setTipoPartido(obj, index);
        return obj;
    }

	public void setCancha(Partido obj, int index) {
        Cancha cancha = canchaDataOnDemand.getRandomCancha();
        obj.setCancha(cancha);
    }

	public void setFechaCreacion(Partido obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaJuego(Partido obj, int index) {
        Date fechaJuego = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaJuego(fechaJuego);
    }

	public void setFechaModificacion(Partido obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setStatus(Partido obj, int index) {
        StatusPartido status = StatusPartido.class.getEnumConstants()[0];
        obj.setStatus(status);
    }

	public void setTipoPartido(Partido obj, int index) {
        TipoPartido tipoPartido = TipoPartido.class.getEnumConstants()[0];
        obj.setTipoPartido(tipoPartido);
    }

	public Partido getSpecificPartido(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Partido obj = data.get(index);
        Long id = obj.getId();
        return partidoService.findPartido(id);
    }

	public Partido getRandomPartido() {
        init();
        Partido obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return partidoService.findPartido(id);
    }

	public boolean modifyPartido(Partido obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = partidoService.findPartidoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Partido' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Partido>();
        for (int i = 0; i < 10; i++) {
            Partido obj = getNewTransientPartido(i);
            try {
                partidoService.savePartido(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            partidoRepository.flush();
            data.add(obj);
        }
    }
}
