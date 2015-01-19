package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Sucursal;
import java.util.List;

public interface SucursalService {

	public abstract long countAllSucursals();


	public abstract void deleteSucursal(Sucursal sucursal);


	public abstract Sucursal findSucursal(Long id);


	public abstract List<Sucursal> findAllSucursals();


	public abstract List<Sucursal> findSucursalEntries(int firstResult, int maxResults);


	public abstract void saveSucursal(Sucursal sucursal);


	public abstract Sucursal updateSucursal(Sucursal sucursal);

}
