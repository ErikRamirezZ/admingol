package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Cancha;
import java.util.List;

public interface CanchaService {

	public abstract long countAllCanchas();


	public abstract void deleteCancha(Cancha cancha);


	public abstract Cancha findCancha(Long id);


	public abstract List<Cancha> findAllCanchas();


	public abstract List<Cancha> findCanchaEntries(int firstResult, int maxResults);


	public abstract void saveCancha(Cancha cancha);


	public abstract Cancha updateCancha(Cancha cancha);

}
