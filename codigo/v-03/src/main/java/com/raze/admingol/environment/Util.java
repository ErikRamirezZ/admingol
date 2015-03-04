package com.raze.admingol.environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import com.raze.admingol.domain.Rol;
import com.raze.admingol.domain.Usuario;

public class Util {

	static Logger log = LoggerFactory.getLogger(Util.class);

	public static Usuario getUsuarioAuthenticated() {
		Usuario principal = (Usuario) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		return principal;
	}

	public static boolean userHasROLE_SUPER() {
		for (Rol rol : getUsuarioAuthenticated().getRol()) {
			if (Constantes.ROLE_SUPER.equals(rol.getNombre())) {
				return true;
			}
		}
		return false;
	}

}
