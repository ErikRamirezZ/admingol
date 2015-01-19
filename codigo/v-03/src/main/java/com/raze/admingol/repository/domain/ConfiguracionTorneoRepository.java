package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.ConfiguracionTorneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionTorneoRepository extends JpaRepository<ConfiguracionTorneo, Long>, JpaSpecificationExecutor<ConfiguracionTorneo> {
}
