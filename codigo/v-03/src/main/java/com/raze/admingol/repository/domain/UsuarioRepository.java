package com.raze.admingol.repository.domain;
import com.raze.admingol.domain.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaSpecificationExecutor<Usuario>, JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM usuario AS u WHERE u.username = :username")
	@Transactional(readOnly = true)
	UserDetails findByUsername(@Param("username") String username);
	
}
