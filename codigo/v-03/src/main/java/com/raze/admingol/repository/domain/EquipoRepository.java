package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaSpecificationExecutor<Equipo>, JpaRepository<Equipo, Long> {
}
