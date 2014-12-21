package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Rol;
import com.raze.admingol.repository.domain.RolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolServiceImpl implements RolService {

	@Autowired
    RolRepository rolRepository;

	public long countAllRols() {
        return rolRepository.count();
    }

	public void deleteRol(Rol rol) {
        rolRepository.delete(rol);
    }

	public Rol findRol(Long id) {
        return rolRepository.findOne(id);
    }

	public List<Rol> findAllRols() {
        return rolRepository.findAll();
    }

	public List<Rol> findRolEntries(int firstResult, int maxResults) {
        return rolRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

	public Rol updateRol(Rol rol) {
        return rolRepository.save(rol);
    }
}
