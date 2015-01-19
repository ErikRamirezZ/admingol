package com.raze.admingol.service.domain;
import com.raze.admingol.domain.CedulaPartido;
import java.util.List;

public interface CedulaPartidoService {

	public abstract long countAllCedulaPartidoes();


	public abstract void deleteCedulaPartido(CedulaPartido cedulaPartido);


	public abstract CedulaPartido findCedulaPartido(Long id);


	public abstract List<CedulaPartido> findAllCedulaPartidoes();


	public abstract List<CedulaPartido> findCedulaPartidoEntries(int firstResult, int maxResults);


	public abstract void saveCedulaPartido(CedulaPartido cedulaPartido);


	public abstract CedulaPartido updateCedulaPartido(CedulaPartido cedulaPartido);

}
