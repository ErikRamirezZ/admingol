package com.raze.admingol.service.domain;
import com.raze.admingol.domain.ConfiguracionNotificaciones;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.ConfiguracionNotificaciones.class })
public interface ConfiguracionNotificacionesService {

	public abstract long countAllConfiguracionNotificacioneses();


	public abstract void deleteConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones);


	public abstract ConfiguracionNotificaciones findConfiguracionNotificaciones(Long id);


	public abstract List<ConfiguracionNotificaciones> findAllConfiguracionNotificacioneses();


	public abstract List<ConfiguracionNotificaciones> findConfiguracionNotificacionesEntries(int firstResult, int maxResults);


	public abstract void saveConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones);


	public abstract ConfiguracionNotificaciones updateConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones);

}
