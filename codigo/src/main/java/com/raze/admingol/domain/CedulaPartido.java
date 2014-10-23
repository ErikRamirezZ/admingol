package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.admingol.catalog.StatusCedula;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findCedulaPartidoesByPartido", "findCedulaPartidoesByPartidoAndStatus" })
@RooJson(deepSerialize = true)
public class CedulaPartido {

    /**
     */
    @NotNull
    @ManyToOne
    private Partido partido;

    /**
     */
    private int marcadorEquipoLocal;

    /**
     */
    private int marcadorEquipoVisitante;

    /**
     */
    private String observaciones;

    /**
     */
    @NotNull
    @ManyToOne
    private StatusCedula status;

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
