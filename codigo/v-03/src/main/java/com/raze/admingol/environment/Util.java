package com.raze.admingol.environment;

import org.springframework.security.core.context.SecurityContextHolder;

import com.raze.admingol.domain.Rol;
import com.raze.admingol.domain.Usuario;

public class Util {

	public static Usuario getUsuarioAuthenticated() {
		return (Usuario) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

	public static boolean userHasROLE_SUPER() {
		for(Rol rol : getUsuarioAuthenticated().getRol()){
			if(Constantes.ROLE_SUPER.equals(rol.getNombre())){
				return true;
			}
		}
		return false;
	}

}
