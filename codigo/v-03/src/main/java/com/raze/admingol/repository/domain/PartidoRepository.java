package com.raze.admingol.repository.domain;
import java.util.Date;
import java.util.List;

import com.raze.admingol.domain.Partido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaSpecificationExecutor<Partido>, JpaRepository<Partido, Long> {

	List<Partido> findByFechaJuegoBetween(Date currentDate, Date currentDate2);
	
}
