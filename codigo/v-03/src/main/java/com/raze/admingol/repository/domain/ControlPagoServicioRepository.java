package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.ControlPagoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = ControlPagoServicio.class)
public interface ControlPagoServicioRepository extends JpaRepository<ControlPagoServicio, Long>, JpaSpecificationExecutor<ControlPagoServicio> {
}
