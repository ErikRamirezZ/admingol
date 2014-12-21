package com.raze.admingol.service.domain;

import com.raze.admingol.domain.ConfiguracionNotificaciones;
import com.raze.admingol.repository.domain.ConfiguracionNotificacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionNotificacionesServiceImpl implements ConfiguracionNotificacionesService {

	@Autowired
    ConfiguracionNotificacionesRepository configuracionNotificacionesRepository;

	public long countAllConfiguracionNotificacioneses() {
        return configuracionNotificacionesRepository.count();
    }

	public void deleteConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones) {
        configuracionNotificacionesRepository.delete(configuracionNotificaciones);
    }

	public ConfiguracionNotificaciones findConfiguracionNotificaciones(Long id) {
        return configuracionNotificacionesRepository.findOne(id);
    }

	public List<ConfiguracionNotificaciones> findAllConfiguracionNotificacioneses() {
        return configuracionNotificacionesRepository.findAll();
    }

	public List<ConfiguracionNotificaciones> findConfiguracionNotificacionesEntries(int firstResult, int maxResults) {
        return configuracionNotificacionesRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones) {
        configuracionNotificacionesRepository.save(configuracionNotificaciones);
    }

	public ConfiguracionNotificaciones updateConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones) {
        return configuracionNotificacionesRepository.save(configuracionNotificaciones);
    }
}
