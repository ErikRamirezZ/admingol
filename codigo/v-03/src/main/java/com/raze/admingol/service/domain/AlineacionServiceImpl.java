package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Alineacion;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.AlineacionRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlineacionServiceImpl implements AlineacionService {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    AlineacionRepository alineacionRepository;

	public long countAllAlineacions() {
        return alineacionRepository.count();
    }

	public void deleteAlineacion(Alineacion alineacion) {
        alineacionRepository.delete(alineacion);
    }

	public Alineacion findAlineacion(Long id) {
        return alineacionRepository.findOne(id);
    }

	public List<Alineacion> findAllAlineacions() {
        return alineacionRepository.findAll();
    }

	public List<Alineacion> findAlineacionEntries(int firstResult, int maxResults) {
        return alineacionRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAlineacion(Alineacion alineacion) {
		alineacion.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		alineacion.setFechaCreacion(new Date());
        alineacionRepository.save(alineacion);
    }

	public Alineacion updateAlineacion(Alineacion alineacion) {
		alineacion.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		alineacion.setFechaModificacion(new Date());
        return alineacionRepository.save(alineacion);
    }
}
