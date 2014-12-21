package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Cancha.class)
public interface CanchaRepository extends JpaSpecificationExecutor<Cancha>, JpaRepository<Cancha, Long> {
}
