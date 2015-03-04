package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Equipo;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.EquipoRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EquipoRepository equipoRepository;

	public long countAllEquipoes() {
		return equipoRepository.count();
	}

	public void deleteEquipo(Equipo equipo) {
		equipoRepository.delete(equipo);
	}

	public Equipo findEquipo(Long id) {
		return equipoRepository.findOne(id);
	}

	public List<Equipo> findAllEquipoes() {
		return equipoRepository.findAll();
	}

	public List<Equipo> findEquipoEntries(int firstResult, int maxResults) {
		return equipoRepository.findAll(
				new org.springframework.data.domain.PageRequest(firstResult
						/ maxResults, maxResults)).getContent();
	}

	public void saveEquipo(Equipo equipo) {
		equipo.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		equipo.setFechaCreacion(new Date());
		equipo.setActivo(true);
		equipoRepository.save(equipo);
	}

	public Equipo updateEquipo(Equipo equipo) {
		equipo.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		equipo.setFechaModificacion(new Date());
		return equipoRepository.save(equipo);
	}
}
