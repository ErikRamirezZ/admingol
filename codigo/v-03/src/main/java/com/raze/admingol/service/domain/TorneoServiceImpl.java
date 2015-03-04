package com.raze.admingol.service.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.admingol.domain.Empresa;
import com.raze.admingol.domain.Sucursal;
import com.raze.admingol.domain.Torneo;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.SucursalRepository;
import com.raze.admingol.repository.domain.TorneoRepository;
import com.raze.admingol.specifications.TorneoSpecifications;

@Service
@Transactional
public class TorneoServiceImpl implements TorneoService {

	static Logger log = LoggerFactory.getLogger(TorneoServiceImpl.class);

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TorneoRepository torneoRepository;

	@Autowired
	SucursalRepository sucursalRepository;

	public long countAllTorneos() {
		return torneoRepository.count();
	}

	public void deleteTorneo(Torneo torneo) {
		torneoRepository.delete(torneo);
	}

	public Torneo findTorneo(Long id) {
		return torneoRepository.findOne(id);
	}

	public List<Torneo> findAllTorneos() {
		log.info("Estoy en findAllTorneos()");
		if (Util.userHasROLE_SUPER()) {
			return torneoRepository.findAll();
		} else {
			return torneoRepository.findAll(TorneoSpecifications
					.torneoInSucursales(sucursalRepository.findByEmpresa(Util
							.getUsuarioAuthenticated().getEmpresa())));
		}

	}

	public List<Torneo> findTorneoEntries(int firstResult, int maxResults) {
		List<Torneo> content = new ArrayList<Torneo>();
		if (Util.userHasROLE_SUPER()) {
			content = torneoRepository.findAll(
					new org.springframework.data.domain.PageRequest(firstResult
							/ maxResults, maxResults)).getContent();
		} else {
			Empresa empresa = Util.getUsuarioAuthenticated().getEmpresa();
			List<Sucursal> sucursales = sucursalRepository
					.findByEmpresa(empresa);
			Specification<Torneo> torneoSpecificationInSucursales = TorneoSpecifications
					.torneoInSucursales(sucursales);
			content = torneoRepository.findAll(
					torneoSpecificationInSucursales,
					new org.springframework.data.domain.PageRequest(firstResult
							/ maxResults, maxResults)).getContent();
		}
		return content;
	}

	public void saveTorneo(Torneo torneo) {
		torneo.setUsuario(usuarioService.findUsuario(Util.getUsuarioAuthenticated().getId()));
		torneo.setFechaCreacion(new Date());
		torneo.setActivo(true);
		torneoRepository.save(torneo);
	}

	public Torneo updateTorneo(Torneo torneo) {
		torneo.setUsuario(usuarioService.findUsuario(Util.getUsuarioAuthenticated().getId()));
		torneo.setFechaModificacion(new Date());
		return torneoRepository.save(torneo);
	}
}
