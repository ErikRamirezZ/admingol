package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Empresa;
import com.raze.admingol.repository.domain.EmpresaRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
    EmpresaRepository empresaRepository;

	public long countAllEmpresas() {
        return empresaRepository.count();
    }

	public void deleteEmpresa(Empresa empresa) {
        empresaRepository.delete(empresa);
    }

	public Empresa findEmpresa(Long id) {
        return empresaRepository.findOne(id);
    }

	public List<Empresa> findAllEmpresas() {
        return empresaRepository.findAll();
    }

	public List<Empresa> findEmpresaEntries(int firstResult, int maxResults) {
        return empresaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEmpresa(Empresa empresa) {
		datosDefault(empresa);
        empresaRepository.save(empresa);
    }

	public Empresa updateEmpresa(Empresa empresa) {
		datosDefault(empresa);
        return empresaRepository.save(empresa);
    }
	
	private void datosDefault(Empresa empresa) {
		empresa.setFechaCreacion(new Date());
		empresa.setActivo(true);		
	}
}
