package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.CedulaPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = CedulaPartido.class)
public interface CedulaPartidoRepository extends JpaRepository<CedulaPartido, Long>, JpaSpecificationExecutor<CedulaPartido> {
}
