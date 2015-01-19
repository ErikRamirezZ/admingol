package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Empresa;
import java.util.List;

public interface EmpresaService {

	public abstract long countAllEmpresas();


	public abstract void deleteEmpresa(Empresa empresa);


	public abstract Empresa findEmpresa(Long id);


	public abstract List<Empresa> findAllEmpresas();


	public abstract List<Empresa> findEmpresaEntries(int firstResult, int maxResults);


	public abstract void saveEmpresa(Empresa empresa);


	public abstract Empresa updateEmpresa(Empresa empresa);

}
