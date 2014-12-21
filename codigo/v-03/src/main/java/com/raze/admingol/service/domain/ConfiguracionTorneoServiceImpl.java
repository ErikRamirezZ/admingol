package com.raze.admingol.service.domain;

import com.raze.admingol.domain.ConfiguracionTorneo;
import com.raze.admingol.repository.domain.ConfiguracionTorneoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionTorneoServiceImpl implements ConfiguracionTorneoService {

	@Autowired
    ConfiguracionTorneoRepository configuracionTorneoRepository;

	public long countAllConfiguracionTorneos() {
        return configuracionTorneoRepository.count();
    }

	public void deleteConfiguracionTorneo(ConfiguracionTorneo configuracionTorneo) {
        configuracionTorneoRepository.delete(configuracionTorneo);
    }

	public ConfiguracionTorneo findConfiguracionTorneo(Long id) {
        return configuracionTorneoRepository.findOne(id);
    }

	public List<ConfiguracionTorneo> findAllConfiguracionTorneos() {
        return configuracionTorneoRepository.findAll();
    }

	public List<ConfiguracionTorneo> findConfiguracionTorneoEntries(int firstResult, int maxResults) {
        return configuracionTorneoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConfiguracionTorneo(ConfiguracionTorneo configuracionTorneo) {
        configuracionTorneoRepository.save(configuracionTorneo);
    }

	public ConfiguracionTorneo updateConfiguracionTorneo(ConfiguracionTorneo configuracionTorneo) {
        return configuracionTorneoRepository.save(configuracionTorneo);
    }
}
