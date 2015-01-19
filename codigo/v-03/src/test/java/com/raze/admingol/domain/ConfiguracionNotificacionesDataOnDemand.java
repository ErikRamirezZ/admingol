package com.raze.admingol.domain;
import com.raze.admingol.catalog.PerodoNotificacion;
import com.raze.admingol.catalog.ViaNotificacion;
import com.raze.admingol.repository.domain.ConfiguracionNotificacionesRepository;
import com.raze.admingol.service.domain.ConfiguracionNotificacionesService;
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
public class ConfiguracionNotificacionesDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<ConfiguracionNotificaciones> data;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    ConfiguracionNotificacionesService configuracionNotificacionesService;

	@Autowired
    ConfiguracionNotificacionesRepository configuracionNotificacionesRepository;

	public ConfiguracionNotificaciones getNewTransientConfiguracionNotificaciones(int index) {
        ConfiguracionNotificaciones obj = new ConfiguracionNotificaciones();
        setActivo(obj, index);
        setFechaCreacion(obj, index);
        setFechaModificacion(obj, index);
        setFecha_hora(obj, index);
        setMensaje(obj, index);
        setRepetir(obj, index);
        setViaNotificacion(obj, index);
        return obj;
    }

	public void setActivo(ConfiguracionNotificaciones obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setFechaCreacion(ConfiguracionNotificaciones obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaModificacion(ConfiguracionNotificaciones obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setFecha_hora(ConfiguracionNotificaciones obj, int index) {
        Date fecha_hora = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFecha_hora(fecha_hora);
    }

	public void setMensaje(ConfiguracionNotificaciones obj, int index) {
        String mensaje = "mensaje_" + index;
        obj.setMensaje(mensaje);
    }

	public void setRepetir(ConfiguracionNotificaciones obj, int index) {
        PerodoNotificacion repetir = PerodoNotificacion.class.getEnumConstants()[0];
        obj.setRepetir(repetir);
    }

	public void setViaNotificacion(ConfiguracionNotificaciones obj, int index) {
        ViaNotificacion viaNotificacion = ViaNotificacion.class.getEnumConstants()[0];
        obj.setViaNotificacion(viaNotificacion);
    }

	public ConfiguracionNotificaciones getSpecificConfiguracionNotificaciones(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ConfiguracionNotificaciones obj = data.get(index);
        Long id = obj.getId();
        return configuracionNotificacionesService.findConfiguracionNotificaciones(id);
    }

	public ConfiguracionNotificaciones getRandomConfiguracionNotificaciones() {
        init();
        ConfiguracionNotificaciones obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return configuracionNotificacionesService.findConfiguracionNotificaciones(id);
    }

	public boolean modifyConfiguracionNotificaciones(ConfiguracionNotificaciones obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = configuracionNotificacionesService.findConfiguracionNotificacionesEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ConfiguracionNotificaciones' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ConfiguracionNotificaciones>();
        for (int i = 0; i < 10; i++) {
            ConfiguracionNotificaciones obj = getNewTransientConfiguracionNotificaciones(i);
            try {
                configuracionNotificacionesService.saveConfiguracionNotificaciones(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            configuracionNotificacionesRepository.flush();
            data.add(obj);
        }
    }
}
