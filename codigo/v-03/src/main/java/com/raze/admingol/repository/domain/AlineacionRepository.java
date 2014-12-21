package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Alineacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Alineacion.class)
public interface AlineacionRepository extends JpaSpecificationExecutor<Alineacion>, JpaRepository<Alineacion, Long> {
}
