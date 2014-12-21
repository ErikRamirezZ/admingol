package com.raze.admingol.service.domain;

import com.raze.admingol.domain.CedulaPartido;
import com.raze.admingol.repository.domain.CedulaPartidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CedulaPartidoServiceImpl implements CedulaPartidoService {

	@Autowired
    CedulaPartidoRepository cedulaPartidoRepository;

	public long countAllCedulaPartidoes() {
        return cedulaPartidoRepository.count();
    }

	public void deleteCedulaPartido(CedulaPartido cedulaPartido) {
        cedulaPartidoRepository.delete(cedulaPartido);
    }

	public CedulaPartido findCedulaPartido(Long id) {
        return cedulaPartidoRepository.findOne(id);
    }

	public List<CedulaPartido> findAllCedulaPartidoes() {
        return cedulaPartidoRepository.findAll();
    }

	public List<CedulaPartido> findCedulaPartidoEntries(int firstResult, int maxResults) {
        return cedulaPartidoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCedulaPartido(CedulaPartido cedulaPartido) {
        cedulaPartidoRepository.save(cedulaPartido);
    }

	public CedulaPartido updateCedulaPartido(CedulaPartido cedulaPartido) {
        return cedulaPartidoRepository.save(cedulaPartido);
    }
}
