package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import com.raze.admingol.catalog.StatusEquipoJugador;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findEquipoesByActivo", "findEquipoesByStatusAndActivo" })
@RooJson(deepSerialize = true)
public class Equipo {

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    @NotNull
    private String nombreCorto;

    /**
     */
    private String nombreLargo;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] logo;

    /**
     */
    @ManyToOne
    private StatusEquipoJugador status;

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
