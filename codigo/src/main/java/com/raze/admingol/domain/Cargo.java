package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import com.raze.admingol.catalog.ConceptoCobro;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.admingol.catalog.StatusCargoAbono;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findCargoesByConceptoCobroAndFechaCreacionBetween", "findCargoesByConceptoCobroAndTorneo", "findCargoesByConceptoCobroAndTorneoAndEquipo", "findCargoesByConceptoCobroAndStatus", "findCargoesByConceptoCobroAndTorneoAndFechaModificacionBetween", "findCargoesByConceptoCobroAndTorneoAndEquipoAndFechaModificacionBetween" })
@RooJson(deepSerialize = true)
public class Cargo {

    /**
     */
    @NotNull
    @ManyToOne
    private ConceptoCobro conceptoCobro;

    /**
     */
    @NotNull
    @ManyToOne
    private Torneo torneo;

    /**
     */
    @NotNull
    @ManyToOne
    private Equipo equipo;

    /**
     */
    @NotNull
    private double monto;

    /**
     */
    private String observaciones;

    /**
     */
    @ManyToOne
    private StatusCargoAbono status;

    /**
     */
    @ManyToOne
    private Abono abono;

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
