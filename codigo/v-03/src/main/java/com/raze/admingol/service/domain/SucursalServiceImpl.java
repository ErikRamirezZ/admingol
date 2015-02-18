package com.raze.admingol.service.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.admingol.domain.Sucursal;
import com.raze.admingol.domain.Usuario;
import com.raze.admingol.repository.domain.SucursalRepository;

@Service
@Transactional
public class SucursalServiceImpl implements SucursalService {

	@Autowired
	SucursalRepository sucursalRepository;

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
		return sucursalRepository.findAll();
	}

	public List<Sucursal> findSucursalEntries(int firstResult, int maxResults) {
		return sucursalRepository.findAll(
				new org.springframework.data.domain.PageRequest(firstResult
						/ maxResults, maxResults)).getContent();
	}

	public void saveSucursal(Sucursal sucursal) {
		datosDefault(sucursal);
		sucursal.setActivo(true);
		sucursalRepository.save(sucursal);
	}

	public Sucursal updateSucursal(Sucursal sucursal) {
		datosDefault(sucursal);
		return sucursalRepository.save(sucursal);
	}

	private void datosDefault(Sucursal sucursal) {
		Usuario principal = (Usuario) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		sucursal.setUsuario(principal);
		sucursal.setFechaCreacion(new Date());
	}

}
