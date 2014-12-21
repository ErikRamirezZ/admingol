package com.raze.admingol.service.domain;

import com.raze.admingol.domain.ControlPagoServicio;
import com.raze.admingol.repository.domain.ControlPagoServicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ControlPagoServicioServiceImpl implements ControlPagoServicioService {

	@Autowired
    ControlPagoServicioRepository controlPagoServicioRepository;

	public long countAllControlPagoServicios() {
        return controlPagoServicioRepository.count();
    }

	public void deleteControlPagoServicio(ControlPagoServicio controlPagoServicio) {
        controlPagoServicioRepository.delete(controlPagoServicio);
    }

	public ControlPagoServicio findControlPagoServicio(Long id) {
        return controlPagoServicioRepository.findOne(id);
    }

	public List<ControlPagoServicio> findAllControlPagoServicios() {
        return controlPagoServicioRepository.findAll();
    }

	public List<ControlPagoServicio> findControlPagoServicioEntries(int firstResult, int maxResults) {
        return controlPagoServicioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveControlPagoServicio(ControlPagoServicio controlPagoServicio) {
        controlPagoServicioRepository.save(controlPagoServicio);
    }

	public ControlPagoServicio updateControlPagoServicio(ControlPagoServicio controlPagoServicio) {
        return controlPagoServicioRepository.save(controlPagoServicio);
    }
}
