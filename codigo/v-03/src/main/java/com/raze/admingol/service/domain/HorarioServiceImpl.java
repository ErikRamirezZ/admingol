package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Horario;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.HorarioRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    HorarioRepository horarioRepository;

	public long countAllHorarios() {
        return horarioRepository.count();
    }

	public void deleteHorario(Horario horario) {
        horarioRepository.delete(horario);
    }

	public Horario findHorario(Long id) {
        return horarioRepository.findOne(id);
    }

	public List<Horario> findAllHorarios() {
        return horarioRepository.findAll();
    }

	public List<Horario> findHorarioEntries(int firstResult, int maxResults) {
        return horarioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveHorario(Horario horario) {
		horario.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		horario.setFechaCreacion(new Date());
		horario.setActivo(true);
        horarioRepository.save(horario);
    }

	public Horario updateHorario(Horario horario) {
		horario.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		horario.setFechaModificacion(new Date());
        return horarioRepository.save(horario);
    }
}
