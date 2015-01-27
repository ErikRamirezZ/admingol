package com.raze.admingol.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.raze.admingol.domain.Usuario;
import com.raze.admingol.service.domain.UsuarioServiceImpl;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	UsuarioServiceImpl usuarioService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();

		Usuario usuario = (Usuario) usuarioService.loadUserByUsername(username);

		if (usuario == null) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(usuario.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Collection<? extends GrantedAuthority> authorities = usuario
				.getAuthorities();

		return new UsernamePasswordAuthenticationToken(usuario, password,
				authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
