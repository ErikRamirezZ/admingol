package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Usuario;
import com.raze.admingol.repository.domain.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
    UsuarioRepository usuarioRepository;

	public long countAllUsuarios() {
        return usuarioRepository.count();
    }

	public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

	public Usuario findUsuario(Long id) {
        return usuarioRepository.findOne(id);
    }

	public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

	public List<Usuario> findUsuarioEntries(int firstResult, int maxResults) {
        return usuarioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

	public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return usuarioRepository.findByUsername(username);
	}
}
