package com.raze.admingol.domain;
import com.raze.admingol.catalog.TipoCobroTorneo;
import com.raze.admingol.repository.domain.ConfiguracionTorneoRepository;
import com.raze.admingol.service.domain.ConfiguracionTorneoService;
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
public class ConfiguracionTorneoDataOnDemand {

	private Random rnd = new SecureRandom();

	private List<ConfiguracionTorneo> data;

	@Autowired
    TorneoDataOnDemand torneoDataOnDemand;

	@Autowired
    UsuarioDataOnDemand usuarioDataOnDemand;

	@Autowired
    ConfiguracionTorneoService configuracionTorneoService;

	@Autowired
    ConfiguracionTorneoRepository configuracionTorneoRepository;

	public ConfiguracionTorneo getNewTransientConfiguracionTorneo(int index) {
        ConfiguracionTorneo obj = new ConfiguracionTorneo();
        setActivo(obj, index);
        setCosto(obj, index);
        setCostoArbitroAuxiliar(obj, index);
        setCostoArbitroPrincipal(obj, index);
        setCostoInscripcion(obj, index);
        setFechaCreacion(obj, index);
        setFechaLimiteRegistro(obj, index);
        setFechaModificacion(obj, index);
        setInscripcion(obj, index);
        setNumeroJugadoresXEquipo(obj, index);
        setNumeroParcialidadesInscripcion(obj, index);
        setNumeroParcialidadesTorneo(obj, index);
        setTiempoDuracionPartido(obj, index);
        setTipoCobroTorneo(obj, index);
        setTorneo(obj, index);
        return obj;
    }

	public void setActivo(ConfiguracionTorneo obj, int index) {
        Boolean activo = Boolean.TRUE;
        obj.setActivo(activo);
    }

	public void setCosto(ConfiguracionTorneo obj, int index) {
        double costo = new Integer(index).doubleValue();
        if (costo > 2D) {
            costo = 2D;
        }
        obj.setCosto(costo);
    }

	public void setCostoArbitroAuxiliar(ConfiguracionTorneo obj, int index) {
        double costoArbitroAuxiliar = new Integer(index).doubleValue();
        obj.setCostoArbitroAuxiliar(costoArbitroAuxiliar);
    }

	public void setCostoArbitroPrincipal(ConfiguracionTorneo obj, int index) {
        double costoArbitroPrincipal = new Integer(index).doubleValue();
        obj.setCostoArbitroPrincipal(costoArbitroPrincipal);
    }

	public void setCostoInscripcion(ConfiguracionTorneo obj, int index) {
        double costoInscripcion = new Integer(index).doubleValue();
        if (costoInscripcion > 2D) {
            costoInscripcion = 2D;
        }
        obj.setCostoInscripcion(costoInscripcion);
    }

	public void setFechaCreacion(ConfiguracionTorneo obj, int index) {
        Date fechaCreacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaCreacion(fechaCreacion);
    }

	public void setFechaLimiteRegistro(ConfiguracionTorneo obj, int index) {
        Date fechaLimiteRegistro = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaLimiteRegistro(fechaLimiteRegistro);
    }

	public void setFechaModificacion(ConfiguracionTorneo obj, int index) {
        Date fechaModificacion = new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH), Calendar.getInstance().get(Calendar.HOUR_OF_DAY), Calendar.getInstance().get(Calendar.MINUTE), Calendar.getInstance().get(Calendar.SECOND) + new Double(Math.random() * 1000).intValue()).getTime();
        obj.setFechaModificacion(fechaModificacion);
    }

	public void setInscripcion(ConfiguracionTorneo obj, int index) {
        Boolean inscripcion = Boolean.TRUE;
        obj.setInscripcion(inscripcion);
    }

	public void setNumeroJugadoresXEquipo(ConfiguracionTorneo obj, int index) {
        int numeroJugadoresXEquipo = index;
        obj.setNumeroJugadoresXEquipo(numeroJugadoresXEquipo);
    }

	public void setNumeroParcialidadesInscripcion(ConfiguracionTorneo obj, int index) {
        int numeroParcialidadesInscripcion = index;
        obj.setNumeroParcialidadesInscripcion(numeroParcialidadesInscripcion);
    }

	public void setNumeroParcialidadesTorneo(ConfiguracionTorneo obj, int index) {
        int numeroParcialidadesTorneo = index;
        obj.setNumeroParcialidadesTorneo(numeroParcialidadesTorneo);
    }

	public void setTiempoDuracionPartido(ConfiguracionTorneo obj, int index) {
        int tiempoDuracionPartido = index;
        obj.setTiempoDuracionPartido(tiempoDuracionPartido);
    }

	public void setTipoCobroTorneo(ConfiguracionTorneo obj, int index) {
        TipoCobroTorneo tipoCobroTorneo = TipoCobroTorneo.class.getEnumConstants()[0];
        obj.setTipoCobroTorneo(tipoCobroTorneo);
    }

	public void setTorneo(ConfiguracionTorneo obj, int index) {
        Torneo torneo = torneoDataOnDemand.getRandomTorneo();
        obj.setTorneo(torneo);
    }

	public ConfiguracionTorneo getSpecificConfiguracionTorneo(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        ConfiguracionTorneo obj = data.get(index);
        Long id = obj.getId();
        return configuracionTorneoService.findConfiguracionTorneo(id);
    }

	public ConfiguracionTorneo getRandomConfiguracionTorneo() {
        init();
        ConfiguracionTorneo obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return configuracionTorneoService.findConfiguracionTorneo(id);
    }

	public boolean modifyConfiguracionTorneo(ConfiguracionTorneo obj) {
        return false;
    }

	public void init() {
        int from = 0;
        int to = 10;
        data = configuracionTorneoService.findConfiguracionTorneoEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'ConfiguracionTorneo' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<ConfiguracionTorneo>();
        for (int i = 0; i < 10; i++) {
            ConfiguracionTorneo obj = getNewTransientConfiguracionTorneo(i);
            try {
                configuracionTorneoService.saveConfiguracionTorneo(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            configuracionTorneoRepository.flush();
            data.add(obj);
        }
    }
}
