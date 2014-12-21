package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Jugador;
import com.raze.admingol.repository.domain.JugadorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JugadorServiceImpl implements JugadorService {

	@Autowired
    JugadorRepository jugadorRepository;

	public long countAllJugadors() {
        return jugadorRepository.count();
    }

	public void deleteJugador(Jugador jugador) {
        jugadorRepository.delete(jugador);
    }

	public Jugador findJugador(Long id) {
        return jugadorRepository.findOne(id);
    }

	public List<Jugador> findAllJugadors() {
        return jugadorRepository.findAll();
    }

	public List<Jugador> findJugadorEntries(int firstResult, int maxResults) {
        return jugadorRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveJugador(Jugador jugador) {
        jugadorRepository.save(jugador);
    }

	public Jugador updateJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }
}
