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
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import com.raze.admingol.catalog.Posicion;
import com.raze.admingol.catalog.StatusEquipoJugador;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findJugadorsByEquipoAndActivo", "findJugadorsByEquipoAndNombreLikeAndActivo", "findJugadorsByEquipoAndNombreLikeAndApellidoPaternoLikeAndActivo", "findJugadorsByEquipoAndStatusAndActivo", "findJugadorsByEquipoAndEsDelegadoAndActivo", "findJugadorsByEquipoAndPosicionAndActivo" })
@RooJson(deepSerialize = true)
public class Jugador {

    /**
     */
    @NotNull
    @ManyToOne
    private Equipo equipo;

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    private String apellidoPaterno;

    /**
     */
    private String apellidoMaterno;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaNacimiento;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] foto;

    /**
     */
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String correoE;

    /**
     */
    private Boolean esDelegado;

    /**
     */
    @ManyToOne
    private Posicion posicion;

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
