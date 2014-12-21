package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Equipo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.Equipo.class })
public interface EquipoService {

	public abstract long countAllEquipoes();


	public abstract void deleteEquipo(Equipo equipo);


	public abstract Equipo findEquipo(Long id);


	public abstract List<Equipo> findAllEquipoes();


	public abstract List<Equipo> findEquipoEntries(int firstResult, int maxResults);


	public abstract void saveEquipo(Equipo equipo);


	public abstract Equipo updateEquipo(Equipo equipo);

}
