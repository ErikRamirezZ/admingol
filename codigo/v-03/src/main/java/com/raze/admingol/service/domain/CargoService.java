package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Cargo;
import java.util.List;

public interface CargoService {

	public abstract long countAllCargoes();


	public abstract void deleteCargo(Cargo cargo);


	public abstract Cargo findCargo(Long id);


	public abstract List<Cargo> findAllCargoes();


	public abstract List<Cargo> findCargoEntries(int firstResult, int maxResults);


	public abstract void saveCargo(Cargo cargo);


	public abstract Cargo updateCargo(Cargo cargo);

}
