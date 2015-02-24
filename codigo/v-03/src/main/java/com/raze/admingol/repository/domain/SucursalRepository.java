package com.raze.admingol.repository.domain;
import java.util.List;

import com.raze.admingol.domain.Empresa;
import com.raze.admingol.domain.Sucursal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>, JpaSpecificationExecutor<Sucursal> {

	List<Sucursal> findByEmpresa(Empresa empresa);
}
