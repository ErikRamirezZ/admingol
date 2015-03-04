package com.raze.admingol.service.domain;

import com.raze.admingol.domain.ConfiguracionNotificaciones;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.ConfiguracionNotificacionesRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConfiguracionNotificacionesServiceImpl implements ConfiguracionNotificacionesService {

	@Autowired
    ConfiguracionNotificacionesRepository configuracionNotificacionesRepository;
	
	@Autowired
	UsuarioService usuarioService;

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
		configuracionNotificaciones.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		configuracionNotificaciones.setFechaCreacion(new Date());
        configuracionNotificacionesRepository.save(configuracionNotificaciones);
    }

	public ConfiguracionNotificaciones updateConfiguracionNotificaciones(ConfiguracionNotificaciones configuracionNotificaciones) {
		configuracionNotificaciones.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		configuracionNotificaciones.setFechaModificacion(new Date());
        return configuracionNotificacionesRepository.save(configuracionNotificaciones);
    }
}
