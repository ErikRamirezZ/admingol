package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.PagoHechoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = PagoHechoServicio.class)
public interface PagoHechoServicioRepository extends JpaRepository<PagoHechoServicio, Long>, JpaSpecificationExecutor<PagoHechoServicio> {
}
