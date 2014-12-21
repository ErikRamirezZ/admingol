package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Sucursal;
import com.raze.admingol.repository.domain.SucursalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SucursalServiceImpl implements SucursalService {

	@Autowired
    SucursalRepository sucursalRepository;

	public long countAllSucursals() {
        return sucursalRepository.count();
    }

	public void deleteSucursal(Sucursal sucursal) {
        sucursalRepository.delete(sucursal);
    }

	public Sucursal findSucursal(Long id) {
        return sucursalRepository.findOne(id);
    }

	public List<Sucursal> findAllSucursals() {
        return sucursalRepository.findAll();
    }

	public List<Sucursal> findSucursalEntries(int firstResult, int maxResults) {
        return sucursalRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveSucursal(Sucursal sucursal) {
        sucursalRepository.save(sucursal);
    }

	public Sucursal updateSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }
}
