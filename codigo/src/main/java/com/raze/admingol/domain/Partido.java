package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.raze.admingol.catalog.TipoPartido;
import com.raze.admingol.catalog.StatusPartido;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitante", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitante", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitante", "findPartidoesByTorneoEquipoLocalAndTorneoEquipoVisitanteAndEquipoLocalAndEquipoVisitanteAndStatus", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndEquipoLocalOrEquipoVisitanteAndStatus", "findPartidoesByTorneoEquipoLocalOrTorneoEquipoVisitanteAndStatus", "findPartidoesByCanchaAndStatusAndFechaJuegoBetween", "findPartidoesByCanchaAndStatusAndFechaJuegoEquals", "findPartidoesByCanchaAndStatus", "findPartidoesByFechaJuegoBetweenAndStatus", "findPartidoesByFechaJuegoEqualsAndStatus", "findPartidoesByCancha" })
@RooJson(deepSerialize = true)
public class Partido {

    /**
     */
    @NotNull
    @ManyToOne
    private Cancha cancha;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Usuario> arbitros = new HashSet<Usuario>();

    /**
     */
    @ManyToOne
    private Torneo torneoEquipoLocal;

    /**
     */
    @ManyToOne
    private Equipo equipoLocal;

    /**
     */
    @ManyToOne
    private Torneo torneoEquipoVisitante;

    /**
     */
    @ManyToOne
    private Equipo equipoVisitante;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaJuego;

    /**
     */
    @ManyToOne
    private Horario horario;

    /**
     */
    @ManyToOne
    private TipoPartido tipoPartido;

    /**
     */
    @NotNull
    @ManyToOne
    private StatusPartido status;

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
