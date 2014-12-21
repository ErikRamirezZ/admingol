package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Cargo;
import com.raze.admingol.repository.domain.CargoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

	@Autowired
    CargoRepository cargoRepository;

	public long countAllCargoes() {
        return cargoRepository.count();
    }

	public void deleteCargo(Cargo cargo) {
        cargoRepository.delete(cargo);
    }

	public Cargo findCargo(Long id) {
        return cargoRepository.findOne(id);
    }

	public List<Cargo> findAllCargoes() {
        return cargoRepository.findAll();
    }

	public List<Cargo> findCargoEntries(int firstResult, int maxResults) {
        return cargoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

	public Cargo updateCargo(Cargo cargo) {
        return cargoRepository.save(cargo);
    }
}
