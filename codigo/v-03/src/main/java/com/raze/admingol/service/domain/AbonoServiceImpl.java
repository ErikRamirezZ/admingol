package com.raze.admingol.service.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.admingol.domain.Abono;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.AbonoRepository;

@Service
@Transactional
public class AbonoServiceImpl implements AbonoService {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
    AbonoRepository abonoRepository;

	public long countAllAbonoes() {
        return abonoRepository.count();
    }

	public void deleteAbono(Abono abono) {
        abonoRepository.delete(abono);
    }

	public Abono findAbono(Long id) {
        return abonoRepository.findOne(id);
    }

	public List<Abono> findAllAbonoes() {
        return abonoRepository.findAll();
    }

	public List<Abono> findAbonoEntries(int firstResult, int maxResults) {
        return abonoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAbono(Abono abono) {
		abono.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		abono.setFechaCreacion(new Date());
		abonoRepository.save(abono);
    }

	public Abono updateAbono(Abono abono) {
		abono.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		abono.setFechaModificacion(new Date());
        return abonoRepository.save(abono);
    }
	
}
