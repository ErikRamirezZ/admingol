package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Sucursal.class)
public interface SucursalRepository extends JpaRepository<Sucursal, Long>, JpaSpecificationExecutor<Sucursal> {
}
