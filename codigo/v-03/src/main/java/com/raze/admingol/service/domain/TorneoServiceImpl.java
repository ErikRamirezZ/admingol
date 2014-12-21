package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Torneo;
import com.raze.admingol.repository.domain.TorneoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TorneoServiceImpl implements TorneoService {

	@Autowired
    TorneoRepository torneoRepository;

	public long countAllTorneos() {
        return torneoRepository.count();
    }

	public void deleteTorneo(Torneo torneo) {
        torneoRepository.delete(torneo);
    }

	public Torneo findTorneo(Long id) {
        return torneoRepository.findOne(id);
    }

	public List<Torneo> findAllTorneos() {
        return torneoRepository.findAll();
    }

	public List<Torneo> findTorneoEntries(int firstResult, int maxResults) {
        return torneoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveTorneo(Torneo torneo) {
        torneoRepository.save(torneo);
    }

	public Torneo updateTorneo(Torneo torneo) {
        return torneoRepository.save(torneo);
    }
}
