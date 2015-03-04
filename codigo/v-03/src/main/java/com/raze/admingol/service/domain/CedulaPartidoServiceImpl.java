package com.raze.admingol.service.domain;

import com.raze.admingol.domain.CedulaPartido;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.CedulaPartidoRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CedulaPartidoServiceImpl implements CedulaPartidoService {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    CedulaPartidoRepository cedulaPartidoRepository;

	public long countAllCedulaPartidoes() {
        return cedulaPartidoRepository.count();
    }

	public void deleteCedulaPartido(CedulaPartido cedulaPartido) {
        cedulaPartidoRepository.delete(cedulaPartido);
    }

	public CedulaPartido findCedulaPartido(Long id) {
        return cedulaPartidoRepository.findOne(id);
    }

	public List<CedulaPartido> findAllCedulaPartidoes() {
        return cedulaPartidoRepository.findAll();
    }

	public List<CedulaPartido> findCedulaPartidoEntries(int firstResult, int maxResults) {
        return cedulaPartidoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCedulaPartido(CedulaPartido cedulaPartido) {
		cedulaPartido.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		cedulaPartido.setFechaCreacion(new Date());
        cedulaPartidoRepository.save(cedulaPartido);
    }

	public CedulaPartido updateCedulaPartido(CedulaPartido cedulaPartido) {
		cedulaPartido.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		cedulaPartido.setFechaModificacion(new Date());
        return cedulaPartidoRepository.save(cedulaPartido);
    }
	
}
