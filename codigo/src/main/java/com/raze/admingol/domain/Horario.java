package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findHorariosByActivo", "findHorariosByCanchaAndActivo" })
@RooJson(deepSerialize = true)
public class Horario {

    /**
     */
    @NotNull
    @ManyToOne
    private Cancha cancha;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date horaInicio;

    /**
     */
    private int duracion;

    /**
     */
    private Boolean lunes;

    /**
     */
    private Boolean martes;

    /**
     */
    private Boolean miercoles;

    /**
     */
    private Boolean jueves;

    /**
     */
    private Boolean viernes;

    /**
     */
    private Boolean sabado;

    /**
     */
    private Boolean domingo;

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
