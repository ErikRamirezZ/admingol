package com.raze.admingol.service.domain;

import com.raze.admingol.domain.PagoHechoServicio;
import com.raze.admingol.repository.domain.PagoHechoServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagoHechoServicioServiceImpl implements PagoHechoServicioService {

	@Autowired
    PagoHechoServicioRepository pagoHechoServicioRepository;

	public long countAllPagoHechoServicios() {
        return pagoHechoServicioRepository.count();
    }

	public void deletePagoHechoServicio(PagoHechoServicio pagoHechoServicio) {
        pagoHechoServicioRepository.delete(pagoHechoServicio);
    }

	public PagoHechoServicio findPagoHechoServicio(Long id) {
        return pagoHechoServicioRepository.findOne(id);
    }

	public List<PagoHechoServicio> findAllPagoHechoServicios() {
        return pagoHechoServicioRepository.findAll();
    }

	public List<PagoHechoServicio> findPagoHechoServicioEntries(int firstResult, int maxResults) {
        return pagoHechoServicioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePagoHechoServicio(PagoHechoServicio pagoHechoServicio) {
        pagoHechoServicioRepository.save(pagoHechoServicio);
    }

	public PagoHechoServicio updatePagoHechoServicio(PagoHechoServicio pagoHechoServicio) {
        return pagoHechoServicioRepository.save(pagoHechoServicio);
    }
}
