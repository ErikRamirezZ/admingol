package com.raze.admingol.service.domain;

import com.raze.admingol.domain.Partido;
import com.raze.admingol.environment.Constant;
import com.raze.admingol.environment.Util;
import com.raze.admingol.repository.domain.PartidoRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PartidoServiceImpl implements PartidoService {

	@Autowired
	UsuarioService usuarioService;
	
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
		partido.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		partido.setFechaCreacion(new Date());
        partidoRepository.save(partido);
    }

	public Partido updatePartido(Partido partido) {
		partido.setUsuario(usuarioService.findUsuario(Util
				.getUsuarioAuthenticated().getId()));
		partido.setFechaModificacion(new Date());
        return partidoRepository.save(partido);
    }

	@Override
	public List<Partido> findPartidoesByFechaAndFrequency(Date currentDate,
			String frequency) {
		if(frequency == Constant.CALENDAR_FREQUECY_MONTHLY){
			return partidoRepository.findByFechaJuegoBetween(
					getStartDatePeriod(currentDate, Constant.CALENDAR_FREQUECY_MONTHLY), 
					getEndDatePeriod(currentDate, Constant.CALENDAR_FREQUECY_MONTHLY));
		} else if(frequency == Constant.CALENDAR_FREQUECY_WEEKLY) {
			return partidoRepository.findByFechaJuegoBetween(
					getStartDatePeriod(currentDate, Constant.CALENDAR_FREQUECY_MONTHLY), 
					getEndDatePeriod(currentDate, Constant.CALENDAR_FREQUECY_MONTHLY));
		} else if(frequency == Constant.CALENDAR_FREQUECY_DAILY) {
			return partidoRepository.findByFechaJuegoBetween(currentDate, currentDate);
		} 
		return null;
	}
	

	/**
	 * Calcula la fecha de inicio de los datos  
	 * SUN = 1; MON = 2; TUE = 3; WED = 4; THU = 5; FRI = 6; SAT = 7;
	 * @param currentDate
	 * @param frequency
	 * @return
	 */
	private Date getStartDatePeriod(Date currentDate, String frequency) {
		Calendar calendarTemp = Calendar.getInstance();
		calendarTemp.setTime(currentDate);

		Calendar calendarStart = Calendar.getInstance();
		
		if(frequency == Constant.CALENDAR_FREQUECY_MONTHLY) {
			calendarStart.set(calendarTemp.get(Calendar.YEAR),
					calendarTemp.get(Calendar.MONTH),
					calendarTemp.getActualMinimum(Calendar.DAY_OF_MONTH),
					calendarTemp.getMinimum(Calendar.HOUR_OF_DAY),
					calendarTemp.getMinimum(Calendar.MINUTE),
					calendarTemp.getMinimum(Calendar.SECOND));
			if(calendarStart.DAY_OF_WEEK == Calendar.SUNDAY) {
				calendarStart.add(Calendar.DAY_OF_YEAR, -6);
			} else if(calendarStart.DAY_OF_WEEK > Calendar.MONDAY) {
				calendarStart.add(Calendar.DAY_OF_YEAR, (calendarStart.DAY_OF_WEEK - Calendar.MONDAY));
			}
		} else {
			calendarStart.set(calendarTemp.get(Calendar.YEAR),
					calendarTemp.get(Calendar.MONTH),
					calendarTemp.get(Calendar.DAY_OF_MONTH),
					calendarTemp.getMinimum(Calendar.HOUR_OF_DAY),
					calendarTemp.getMinimum(Calendar.MINUTE),
					calendarTemp.getMinimum(Calendar.SECOND));
			if (frequency == Constant.CALENDAR_FREQUECY_WEEKLY) {
				if(calendarStart.DAY_OF_WEEK == Calendar.SUNDAY) {
					calendarStart.add(Calendar.DAY_OF_YEAR, -6);
				} else if(calendarStart.DAY_OF_WEEK > Calendar.MONDAY) {
					calendarStart.add(Calendar.DAY_OF_YEAR, (calendarStart.DAY_OF_WEEK - Calendar.MONDAY));
				}				
			}
		}
		return calendarStart.getTime();
	}

	/**
	 * Calcula la fecha ultima para mostrar los datos
	 * SUN = 1; MON = 2; TUE = 3; WED = 4; THU = 5; FRI = 6; SAT = 7;
	 * @param currentDate
	 * @param frequency
	 * @return
	 */
	private Date getEndDatePeriod(Date currentDate, String frequency) {
		Calendar calendarTemp = Calendar.getInstance();
		calendarTemp.setTime(currentDate);

		Calendar calendarEnd = Calendar.getInstance();
		
		if(frequency == Constant.CALENDAR_FREQUECY_MONTHLY) {
			calendarEnd.set(calendarTemp.get(Calendar.YEAR),
					calendarTemp.get(Calendar.MONTH),
					calendarTemp.getActualMaximum(Calendar.DAY_OF_MONTH),
					calendarTemp.getMaximum(Calendar.HOUR_OF_DAY),
					calendarTemp.getMaximum(Calendar.MINUTE),
					calendarTemp.getMaximum(Calendar.SECOND));
			if(calendarEnd.DAY_OF_WEEK > Calendar.SUNDAY) {
				calendarEnd.add(Calendar.DAY_OF_YEAR, (8 - calendarEnd.DAY_OF_WEEK));
			}
		} else {
			calendarEnd.set(calendarTemp.get(Calendar.YEAR),
					calendarTemp.get(Calendar.MONTH),
					calendarTemp.get(Calendar.DAY_OF_MONTH),
					calendarTemp.getMaximum(Calendar.HOUR_OF_DAY),
					calendarTemp.getMaximum(Calendar.MINUTE),
					calendarTemp.getMaximum(Calendar.SECOND));
			if(frequency == Constant.CALENDAR_FREQUECY_MONTHLY) {
				if(calendarEnd.DAY_OF_WEEK > Calendar.SUNDAY) {
					calendarEnd.add(Calendar.DAY_OF_YEAR, (8 - calendarEnd.DAY_OF_WEEK));
				}				
			}
		}
		return calendarEnd.getTime();
	}

	
}
