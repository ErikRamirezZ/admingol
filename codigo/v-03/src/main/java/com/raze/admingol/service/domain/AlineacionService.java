package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Alineacion;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.Alineacion.class })
public interface AlineacionService {

	public abstract long countAllAlineacions();


	public abstract void deleteAlineacion(Alineacion alineacion);


	public abstract Alineacion findAlineacion(Long id);


	public abstract List<Alineacion> findAllAlineacions();


	public abstract List<Alineacion> findAlineacionEntries(int firstResult, int maxResults);


	public abstract void saveAlineacion(Alineacion alineacion);


	public abstract Alineacion updateAlineacion(Alineacion alineacion);

}
