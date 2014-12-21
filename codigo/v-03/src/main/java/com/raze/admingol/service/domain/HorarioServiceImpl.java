package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Horario;
import com.raze.admingol.repository.domain.HorarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HorarioServiceImpl implements HorarioService {

	@Autowired
    HorarioRepository horarioRepository;

	public long countAllHorarios() {
        return horarioRepository.count();
    }

	public void deleteHorario(Horario horario) {
        horarioRepository.delete(horario);
    }

	public Horario findHorario(Long id) {
        return horarioRepository.findOne(id);
    }

	public List<Horario> findAllHorarios() {
        return horarioRepository.findAll();
    }

	public List<Horario> findHorarioEntries(int firstResult, int maxResults) {
        return horarioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveHorario(Horario horario) {
        horarioRepository.save(horario);
    }

	public Horario updateHorario(Horario horario) {
        return horarioRepository.save(horario);
    }
}
