package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Estadisticas;
import java.util.List;

public interface EstadisticasService {

	public abstract long countAllEstadisticases();


	public abstract void deleteEstadisticas(Estadisticas estadisticas);


	public abstract Estadisticas findEstadisticas(Long id);


	public abstract List<Estadisticas> findAllEstadisticases();


	public abstract List<Estadisticas> findEstadisticasEntries(int firstResult, int maxResults);


	public abstract void saveEstadisticas(Estadisticas estadisticas);


	public abstract Estadisticas updateEstadisticas(Estadisticas estadisticas);

}
