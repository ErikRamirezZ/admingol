package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Estadisticas;
import com.raze.admingol.repository.domain.EstadisticasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstadisticasServiceImpl implements EstadisticasService {

	@Autowired
    EstadisticasRepository estadisticasRepository;

	public long countAllEstadisticases() {
        return estadisticasRepository.count();
    }

	public void deleteEstadisticas(Estadisticas estadisticas) {
        estadisticasRepository.delete(estadisticas);
    }

	public Estadisticas findEstadisticas(Long id) {
        return estadisticasRepository.findOne(id);
    }

	public List<Estadisticas> findAllEstadisticases() {
        return estadisticasRepository.findAll();
    }

	public List<Estadisticas> findEstadisticasEntries(int firstResult, int maxResults) {
        return estadisticasRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEstadisticas(Estadisticas estadisticas) {
        estadisticasRepository.save(estadisticas);
    }

	public Estadisticas updateEstadisticas(Estadisticas estadisticas) {
        return estadisticasRepository.save(estadisticas);
    }
}
