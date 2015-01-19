package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Abono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonoRepository extends JpaSpecificationExecutor<Abono>, JpaRepository<Abono, Long> {
}
