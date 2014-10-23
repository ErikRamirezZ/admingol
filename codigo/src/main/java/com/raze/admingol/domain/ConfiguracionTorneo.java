package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMax;
import com.raze.admingol.catalog.TipoCobro;
import com.raze.admingol.catalog.DiasJuego;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findConfiguracionTorneosByTorneoAndActivo", "findConfiguracionTorneosByTipoCobroAndActivo", "findConfiguracionTorneosByInscripcionAndActivo" })
@RooJson(deepSerialize = true)
public class ConfiguracionTorneo {

    /**
     */
    @NotNull
    @ManyToOne
    private Torneo torneo;

    /**
     */
    private Boolean inscripcion;

    /**
     */
    @DecimalMax("2")
    private double costoIncripcion;

    /**
     */
    @ManyToOne
    private TipoCobro tipoCobro;

    /**
     */
    @DecimalMax("2")
    private double costo;

    /**
     */
    private int numeroPagos;

    /**
     */
    private int numeroJugadoresXEquipo;

    /**
     */
    @ManyToOne
    private DiasJuego diasJuego;

    /**
     */
    private Boolean activo;

    /**
     */
    @ManyToOne
    private Usuario usuario;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaCreacion;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaModificacion;
}
