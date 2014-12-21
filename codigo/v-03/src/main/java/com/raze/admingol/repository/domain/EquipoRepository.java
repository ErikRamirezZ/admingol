package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Equipo.class)
public interface EquipoRepository extends JpaSpecificationExecutor<Equipo>, JpaRepository<Equipo, Long> {
}
