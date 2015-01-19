package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.PagoHechoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoHechoServicioRepository extends JpaRepository<PagoHechoServicio, Long>, JpaSpecificationExecutor<PagoHechoServicio> {
}
