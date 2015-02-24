package com.raze.admingol.repository.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.raze.admingol.domain.Equipo;

@Repository
public interface EquipoRepository extends JpaSpecificationExecutor<Equipo>, JpaRepository<Equipo, Long> {
	
}
