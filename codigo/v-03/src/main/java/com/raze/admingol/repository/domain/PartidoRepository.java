package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Partido.class)
public interface PartidoRepository extends JpaSpecificationExecutor<Partido>, JpaRepository<Partido, Long> {
}
