package com.raze.admingol.service.domain;
import com.raze.admingol.domain.Jugador;
import java.util.List;

public interface JugadorService {

	public abstract long countAllJugadors();


	public abstract void deleteJugador(Jugador jugador);


	public abstract Jugador findJugador(Long id);


	public abstract List<Jugador> findAllJugadors();


	public abstract List<Jugador> findJugadorEntries(int firstResult, int maxResults);


	public abstract void saveJugador(Jugador jugador);


	public abstract Jugador updateJugador(Jugador jugador);

}
