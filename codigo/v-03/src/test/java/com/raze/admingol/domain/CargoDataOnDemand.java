package com.raze.admingol.domain;
import com.raze.admingol.catalog.ConceptoCobro;
import com.raze.admingol.catalog.StatusCargoAbono;
import com.raze.admingol.repository.domain.CargoRepository;
import com.raze.admingol.service.domain.CargoService;
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

@Configurable
@Component
public class CargoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Cargo> data;

	@Autowired
    AbonoDataOnDemand abonoDataOnDemand;

	@Autowired
    EquipoDataOnDemand equipoDataOnDemand;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    CargoService cargoService;

	@Autowired
    CargoRepository cargoRepository;

	public Cargo getNewTransientCargo(int index) {
        Cargo obj = new Cargo();
        setConceptoCobro(obj, index);
        setEquipo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMonto(obj, index);
        setObservaciones(obj, index);
        setStatus(obj, index);
        setTorneo(obj, index);
        return obj;
    }

	public void setConceptoCobro(Cargo obj, int index) {
        ConceptoCobro conceptoCobro = ConceptoCobro.class.getEnumConstants()[0];
        obj.setConceptoCobro(conceptoCobro);
    }

	public void setEquipo(Cargo obj, int index) {
        Equipo equipo = equipoDataOnDemand.getRandomEquipo();
        obj.setEquipo(equipo);
    }

	public void setFechaCreacion(Cargo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Cargo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMonto(Cargo obj, int index) {
        double monto = new Integer(index).doubleValue();
        obj.setMonto(monto);
    }

	public void setObservaciones(Cargo obj, int index) {
        String observaciones = "observaciones_" + index;
        obj.setObservaciones(observaciones);
    }

	public void setStatus(Cargo obj, int index) {
        StatusCargoAbono status = StatusCargoAbono.class.getEnumConstants()[0];
        obj.setStatus(status);
    }

	public void setTorneo(Cargo obj, int index) {
        Torneo torneo = torneoDataOnDemand.getRandomTorneo();
        obj.setTorneo(torneo);
    }

	public Cargo getSpecificCargo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Cargo obj = data.get(index);
        Long id = obj.getId();
        return cargoService.findCargo(id);
    }

	public Cargo getRandomCargo() {
        init();
        Cargo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return cargoService.findCargo(id);
    }

	public boolean modifyCargo(Cargo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = cargoService.findCargoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Cargo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Cargo>();
        for (int i = 0; i < 10; i++) {
            Cargo obj = getNewTransientCargo(i);
            try {
                cargoService.saveCargo(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            cargoRepository.flush();
            data.add(obj);
        }
    }
}
