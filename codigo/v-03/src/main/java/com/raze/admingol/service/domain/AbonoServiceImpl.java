package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Abono;
import com.raze.admingol.repository.domain.AbonoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AbonoServiceImpl implements AbonoService {

	@Autowired
    AbonoRepository abonoRepository;

	public long countAllAbonoes() {
        return abonoRepository.count();
    }

	public void deleteAbono(Abono abono) {
        abonoRepository.delete(abono);
    }

	public Abono findAbono(Long id) {
        return abonoRepository.findOne(id);
    }

	public List<Abono> findAllAbonoes() {
        return abonoRepository.findAll();
    }

	public List<Abono> findAbonoEntries(int firstResult, int maxResults) {
        return abonoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAbono(Abono abono) {
        abonoRepository.save(abono);
    }

	public Abono updateAbono(Abono abono) {
        return abonoRepository.save(abono);
    }
}
