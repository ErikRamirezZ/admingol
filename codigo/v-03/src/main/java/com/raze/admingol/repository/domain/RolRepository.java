package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Rol.class)
public interface RolRepository extends JpaRepository<Rol, Long>, JpaSpecificationExecutor<Rol> {
}
