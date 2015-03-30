package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Partido;

import java.util.Date;
import java.util.List;

public interface PartidoService {

	public abstract long countAllPartidoes();


	public abstract void deletePartido(Partido partido);


	public abstract Partido findPartido(Long id);


	public abstract List<Partido> findAllPartidoes();


	public abstract List<Partido> findPartidoEntries(int firstResult, int maxResults);


	public abstract void savePartido(Partido partido);


	public abstract Partido updatePartido(Partido partido);


	public abstract List<Partido> findPartidoesByFechaAndFrequency(
			Date currentDate, String frequency);

}
