package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Cancha;
import com.raze.admingol.repository.domain.CanchaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CanchaServiceImpl implements CanchaService {

	@Autowired
    CanchaRepository canchaRepository;

	public long countAllCanchas() {
        return canchaRepository.count();
    }

	public void deleteCancha(Cancha cancha) {
        canchaRepository.delete(cancha);
    }

	public Cancha findCancha(Long id) {
        return canchaRepository.findOne(id);
    }

	public List<Cancha> findAllCanchas() {
        return canchaRepository.findAll();
    }

	public List<Cancha> findCanchaEntries(int firstResult, int maxResults) {
        return canchaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCancha(Cancha cancha) {
        canchaRepository.save(cancha);
    }

	public Cancha updateCancha(Cancha cancha) {
        return canchaRepository.save(cancha);
    }
}
