package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.ControlPagoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlPagoServicioRepository extends JpaRepository<ControlPagoServicio, Long>, JpaSpecificationExecutor<ControlPagoServicio> {
}
