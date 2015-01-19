package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Cancha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CanchaRepository extends JpaSpecificationExecutor<Cancha>, JpaRepository<Cancha, Long> {
}
