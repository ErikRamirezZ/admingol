package com.raze.admingol.service.domain;
import com.raze.admingol.domain.PagoHechoServicio;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.admingol.domain.PagoHechoServicio.class })
public interface PagoHechoServicioService {

	public abstract long countAllPagoHechoServicios();


	public abstract void deletePagoHechoServicio(PagoHechoServicio pagoHechoServicio);


	public abstract PagoHechoServicio findPagoHechoServicio(Long id);


	public abstract List<PagoHechoServicio> findAllPagoHechoServicios();


	public abstract List<PagoHechoServicio> findPagoHechoServicioEntries(int firstResult, int maxResults);


	public abstract void savePagoHechoServicio(PagoHechoServicio pagoHechoServicio);


	public abstract PagoHechoServicio updatePagoHechoServicio(PagoHechoServicio pagoHechoServicio);

}
