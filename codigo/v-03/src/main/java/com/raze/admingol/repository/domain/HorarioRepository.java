package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Horario.class)
public interface HorarioRepository extends JpaRepository<Horario, Long>, JpaSpecificationExecutor<Horario> {
}
