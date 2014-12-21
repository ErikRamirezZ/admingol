package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Partido;
import com.raze.admingol.repository.domain.PartidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartidoServiceImpl implements PartidoService {

	@Autowired
    PartidoRepository partidoRepository;

	public long countAllPartidoes() {
        return partidoRepository.count();
    }

	public void deletePartido(Partido partido) {
        partidoRepository.delete(partido);
    }

	public Partido findPartido(Long id) {
        return partidoRepository.findOne(id);
    }

	public List<Partido> findAllPartidoes() {
        return partidoRepository.findAll();
    }

	public List<Partido> findPartidoEntries(int firstResult, int maxResults) {
        return partidoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePartido(Partido partido) {
        partidoRepository.save(partido);
    }

	public Partido updatePartido(Partido partido) {
        return partidoRepository.save(partido);
    }
}
