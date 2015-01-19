package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Abono;
import java.util.List;

public interface AbonoService {

	public abstract long countAllAbonoes();


	public abstract void deleteAbono(Abono abono);


	public abstract Abono findAbono(Long id);


	public abstract List<Abono> findAllAbonoes();


	public abstract List<Abono> findAbonoEntries(int firstResult, int maxResults);


	public abstract void saveAbono(Abono abono);


	public abstract Abono updateAbono(Abono abono);

}
