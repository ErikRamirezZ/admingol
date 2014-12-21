package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Cancha;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.Cancha.class })
public interface CanchaService {

	public abstract long countAllCanchas();


	public abstract void deleteCancha(Cancha cancha);


	public abstract Cancha findCancha(Long id);


	public abstract List<Cancha> findAllCanchas();


	public abstract List<Cancha> findCanchaEntries(int firstResult, int maxResults);


	public abstract void saveCancha(Cancha cancha);


	public abstract Cancha updateCancha(Cancha cancha);

}
