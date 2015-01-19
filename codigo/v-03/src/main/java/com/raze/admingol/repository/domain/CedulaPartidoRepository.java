package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.CedulaPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CedulaPartidoRepository extends JpaRepository<CedulaPartido, Long>, JpaSpecificationExecutor<CedulaPartido> {
}
