package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Empresa.class)
public interface EmpresaRepository extends JpaSpecificationExecutor<Empresa>, JpaRepository<Empresa, Long> {
}
