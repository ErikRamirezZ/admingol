package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Partido;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.Partido.class })
public interface PartidoService {

	public abstract long countAllPartidoes();


	public abstract void deletePartido(Partido partido);


	public abstract Partido findPartido(Long id);


	public abstract List<Partido> findAllPartidoes();


	public abstract List<Partido> findPartidoEntries(int firstResult, int maxResults);


	public abstract void savePartido(Partido partido);


	public abstract Partido updatePartido(Partido partido);

}
