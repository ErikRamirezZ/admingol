package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Usuario.class)
public interface UsuarioRepository extends JpaSpecificationExecutor<Usuario>, JpaRepository<Usuario, Long> {
}
