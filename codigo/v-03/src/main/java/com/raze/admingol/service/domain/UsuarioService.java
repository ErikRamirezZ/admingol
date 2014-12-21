package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Usuario;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.Usuario.class })
public interface UsuarioService {

	public abstract long countAllUsuarios();


	public abstract void deleteUsuario(Usuario usuario);


	public abstract Usuario findUsuario(Long id);


	public abstract List<Usuario> findAllUsuarios();


	public abstract List<Usuario> findUsuarioEntries(int firstResult, int maxResults);


	public abstract void saveUsuario(Usuario usuario);


	public abstract Usuario updateUsuario(Usuario usuario);

}
