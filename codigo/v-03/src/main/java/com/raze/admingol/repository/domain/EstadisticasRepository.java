package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Estadisticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Estadisticas.class)
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Long>, JpaSpecificationExecutor<Estadisticas> {
}
