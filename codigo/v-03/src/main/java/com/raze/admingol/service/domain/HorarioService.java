package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Horario;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.Horario.class })
public interface HorarioService {

	public abstract long countAllHorarios();


	public abstract void deleteHorario(Horario horario);


	public abstract Horario findHorario(Long id);


	public abstract List<Horario> findAllHorarios();


	public abstract List<Horario> findHorarioEntries(int firstResult, int maxResults);


	public abstract void saveHorario(Horario horario);


	public abstract Horario updateHorario(Horario horario);

}
