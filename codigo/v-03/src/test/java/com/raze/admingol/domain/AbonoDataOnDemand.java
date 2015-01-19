package com.raze.admingol.domain;
import com.raze.admingol.catalog.Descuento;
import com.raze.admingol.catalog.MetodoPago;
import com.raze.admingol.catalog.StatusCargoAbono;
import com.raze.admingol.repository.domain.AbonoRepository;
import com.raze.admingol.service.domain.AbonoService;
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
public class AbonoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<Abono> data;

	@Autowired
    CargoDataOnDemand cargoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    AbonoService abonoService;

	@Autowired
    AbonoRepository abonoRepository;

	public Abono getNewTransientAbono(int index) {
        Abono obj = new Abono();
        setCargo(obj, index);
        setDescuento(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setMetodoPago(obj, index);
        setObservaciones(obj, index);
        setStatus(obj, index);
        return obj;
    }

	public void setCargo(Abono obj, int index) {
        Cargo cargo = cargoDataOnDemand.getRandomCargo();
        obj.setCargo(cargo);
    }

	public void setDescuento(Abono obj, int index) {
        Descuento descuento = Descuento.class.getEnumConstants()[0];
        obj.setDescuento(descuento);
    }

	public void setFechaCreacion(Abono obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(Abono obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setMetodoPago(Abono obj, int index) {
        MetodoPago metodoPago = MetodoPago.class.getEnumConstants()[0];
        obj.setMetodoPago(metodoPago);
    }

	public void setObservaciones(Abono obj, int index) {
        String observaciones = "observaciones_" + index;
        obj.setObservaciones(observaciones);
    }

	public void setStatus(Abono obj, int index) {
        StatusCargoAbono status = StatusCargoAbono.class.getEnumConstants()[0];
        obj.setStatus(status);
    }

	public Abono getSpecificAbono(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        Abono obj = data.get(index);
        Long id = obj.getId();
        return abonoService.findAbono(id);
    }

	public Abono getRandomAbono() {
        init();
        Abono obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return abonoService.findAbono(id);
    }

	public boolean modifyAbono(Abono obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = abonoService.findAbonoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'Abono' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<Abono>();
        for (int i = 0; i < 10; i++) {
            Abono obj = getNewTransientAbono(i);
            try {
                abonoService.saveAbono(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            abonoRepository.flush();
            data.add(obj);
        }
    }
}
