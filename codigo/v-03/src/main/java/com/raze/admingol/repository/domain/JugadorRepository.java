package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Jugador.class)
public interface JugadorRepository extends JpaSpecificationExecutor<Jugador>, JpaRepository<Jugador, Long> {
}
