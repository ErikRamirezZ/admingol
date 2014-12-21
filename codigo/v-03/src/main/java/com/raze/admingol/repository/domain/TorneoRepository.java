package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Torneo.class)
public interface TorneoRepository extends JpaRepository<Torneo, Long>, JpaSpecificationExecutor<Torneo> {
}
