package com.raze.admingol.domain;
import com.raze.admingol.catalog.FechaVencimientoTC;
import com.raze.admingol.catalog.TipoTarjeta;
import com.raze.admingol.repository.domain.ControlPagoServicioRepository;
import com.raze.admingol.service.domain.ControlPagoServicioService;
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
public class ControlPagoServicioDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<ControlPagoServicio> data;

	@Autowired
    EmpresaDataOnDemand empresaDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    ControlPagoServicioService controlPagoServicioService;

	@Autowired
    ControlPagoServicioRepository controlPagoServicioRepository;

	public ControlPagoServicio getNewTransientControlPagoServicio(int index) {
        ControlPagoServicio obj = new ControlPagoServicio();
        setActivo(obj, index);
        setCodigoSeguridad(obj, index);
        setCuenta(obj, index);
        setEmpresa(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFechaVencimientoTC(obj, index);
        setNoReferencia(obj, index);
        setNoTC(obj, index);
        setTarfa(obj, index);
        setTipoTarjeta(obj, index);
        return obj;
    }

	public void setActivo(ControlPagoServicio obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCodigoSeguridad(ControlPagoServicio obj, int index) {
        int codigoSeguridad = index;
        obj.setCodigoSeguridad(codigoSeguridad);
    }

	public void setCuenta(ControlPagoServicio obj, int index) {
        int cuenta = index;
        obj.setCuenta(cuenta);
    }

	public void setEmpresa(ControlPagoServicio obj, int index) {
        Empresa empresa = empresaDataOnDemand.getRandomEmpresa();
        obj.setEmpresa(empresa);
    }

	public void setFechaCreacion(ControlPagoServicio obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(ControlPagoServicio obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFechaVencimientoTC(ControlPagoServicio obj, int index) {
        FechaVencimientoTC fechaVencimientoTC = FechaVencimientoTC.class.getEnumConstants()[0];
        obj.setFechaVencimientoTC(fechaVencimientoTC);
    }

	public void setNoReferencia(ControlPagoServicio obj, int index) {
        int noReferencia = index;
        obj.setNoReferencia(noReferencia);
    }

	public void setNoTC(ControlPagoServicio obj, int index) {
        int noTC = index;
        obj.setNoTC(noTC);
    }

	public void setTarfa(ControlPagoServicio obj, int index) {
        double tarfa = new Integer(index).doubleValue();
        obj.setTarfa(tarfa);
    }

	public void setTipoTarjeta(ControlPagoServicio obj, int index) {
        TipoTarjeta tipoTarjeta = TipoTarjeta.class.getEnumConstants()[0];
        obj.setTipoTarjeta(tipoTarjeta);
    }

	public ControlPagoServicio getSpecificControlPagoServicio(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ControlPagoServicio obj = data.get(index);
        Long id = obj.getId();
        return controlPagoServicioService.findControlPagoServicio(id);
    }

	public ControlPagoServicio getRandomControlPagoServicio() {
        init();
        ControlPagoServicio obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return controlPagoServicioService.findControlPagoServicio(id);
    }

	public boolean modifyControlPagoServicio(ControlPagoServicio obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = controlPagoServicioService.findControlPagoServicioEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ControlPagoServicio' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ControlPagoServicio>();
        for (int i = 0; i < 10; i++) {
            ControlPagoServicio obj = getNewTransientControlPagoServicio(i);
            try {
                controlPagoServicioService.saveControlPagoServicio(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            controlPagoServicioRepository.flush();
            data.add(obj);
        }
    }
}
