package com.raze.admingol.service.domain;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.admingol.domain.Sucursal;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.SucursalRepository;

@Service
@Transactional
public class SucursalServiceImpl implements SucursalService {

	static Logger log = LoggerFactory.getLogger(SucursalServiceImpl.class);

	@Autowired
	SucursalRepository sucursalRepository;

	@Autowired
	UsuarioService usuarioService;

	public long countAllSucursals() {
		return sucursalRepository.count();
	}

	public void deleteSucursal(Sucursal sucursal) {
		sucursalRepository.delete(sucursal);
	}

	public Sucursal findSucursal(Long id) {
		return sucursalRepository.findOne(id);
	}

	public List<Sucursal> findAllSucursals() {
		if (Util.userHasROLE_SUPER()) {
			return sucursalRepository.findAll();
		} else {
			return sucursalRepository.findByEmpresa(Util
					.getUsuarioAuthenticated().getEmpresa());
		}
	}

	public List<Sucursal> findSucursalEntries(int firstResult, int maxResults) {
		return sucursalRepository.findAll(
				new org.springframework.data.domain.PageRequest(firstResult
						/ maxResults, maxResults)).getContent();
	}

	public void saveSucursal(Sucursal sucursal) {
		sucursal.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		sucursal.setFechaCreacion(new Date());
		sucursal.setActivo(true);
		sucursalRepository.save(sucursal);
	}

	public Sucursal updateSucursal(Sucursal sucursal) {
		sucursal.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		sucursal.setFechaModificacion(new Date());
		return sucursalRepository.save(sucursal);
	}
	
}
