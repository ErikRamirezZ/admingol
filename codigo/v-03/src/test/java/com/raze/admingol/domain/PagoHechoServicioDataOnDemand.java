package com.raze.admingol.domain;
import com.raze.admingol.repository.domain.PagoHechoServicioRepository;
import com.raze.admingol.service.domain.PagoHechoServicioService;
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
public class PagoHechoServicioDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<PagoHechoServicio> data;

	@Autowired
    ControlPagoServicioDataOnDemand controlPagoServicioDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    PagoHechoServicioService pagoHechoServicioService;

	@Autowired
    PagoHechoServicioRepository pagoHechoServicioRepository;

	public PagoHechoServicio getNewTransientPagoHechoServicio(int index) {
        PagoHechoServicio obj = new PagoHechoServicio();
        setActivo(obj, index);
        setControlPagoServicio(obj, index);
        setDescuento(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaPago(obj, index);
        setFechaVencimiento(obj, index);
        setMonto(obj, index);
        return obj;
    }

	public void setActivo(PagoHechoServicio obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setControlPagoServicio(PagoHechoServicio obj, int index) {
        ControlPagoServicio controlPagoServicio = controlPagoServicioDataOnDemand.getRandomControlPagoServicio();
        obj.setControlPagoServicio(controlPagoServicio);
    }

	public void setDescuento(PagoHechoServicio obj, int index) {
        int descuento = index;
        obj.setDescuento(descuento);
    }

	public void setFechaCreacion(PagoHechoServicio obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(PagoHechoServicio obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaPago(PagoHechoServicio obj, int index) {
        Date fechaPago = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaPago(fechaPago);
    }

	public void setFechaVencimiento(PagoHechoServicio obj, int index) {
        Date fechaVencimiento = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaVencimiento(fechaVencimiento);
    }

	public void setMonto(PagoHechoServicio obj, int index) {
        double monto = new Integer(index).doubleValue();
        obj.setMonto(monto);
    }

	public PagoHechoServicio getSpecificPagoHechoServicio(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        PagoHechoServicio obj = data.get(index);
        Long id = obj.getId();
        return pagoHechoServicioService.findPagoHechoServicio(id);
    }

	public PagoHechoServicio getRandomPagoHechoServicio() {
        init();
        PagoHechoServicio obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return pagoHechoServicioService.findPagoHechoServicio(id);
    }

	public boolean modifyPagoHechoServicio(PagoHechoServicio obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = pagoHechoServicioService.findPagoHechoServicioEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'PagoHechoServicio' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<PagoHechoServicio>();
        for (int i = 0; i < 10; i++) {
            PagoHechoServicio obj = getNewTransientPagoHechoServicio(i);
            try {
                pagoHechoServicioService.savePagoHechoServicio(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            pagoHechoServicioRepository.flush();
            data.add(obj);
        }
    }
}
