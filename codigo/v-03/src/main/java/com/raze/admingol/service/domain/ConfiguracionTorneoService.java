package com.raze.admingol.service.domain;
import com.raze.admingol.domain.ConfiguracionTorneo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.ConfiguracionTorneo.class })
public interface ConfiguracionTorneoService {

	public abstract long countAllConfiguracionTorneos();


	public abstract void deleteConfiguracionTorneo(ConfiguracionTorneo configuracionTorneo);


	public abstract ConfiguracionTorneo findConfiguracionTorneo(Long id);


	public abstract List<ConfiguracionTorneo> findAllConfiguracionTorneos();


	public abstract List<ConfiguracionTorneo> findConfiguracionTorneoEntries(int firstResult, int maxResults);


	public abstract void saveConfiguracionTorneo(ConfiguracionTorneo configuracionTorneo);


	public abstract ConfiguracionTorneo updateConfiguracionTorneo(ConfiguracionTorneo configuracionTorneo);

}
