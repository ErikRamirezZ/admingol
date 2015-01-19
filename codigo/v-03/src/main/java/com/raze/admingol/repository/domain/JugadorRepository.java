package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaSpecificationExecutor<Jugador>, JpaRepository<Jugador, Long> {
}
