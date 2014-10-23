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
import com.raze.admingol.catalog.Rol;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findUsuariosByEmpresaAndActivo", "findUsuariosByEmpresaAndNombreLikeAndActivo", "findUsuariosByApellidoPaternoLike", "findUsuariosByRolAndActivo" })
@RooJson(deepSerialize = true)
public class Usuario {

    /**
     */
    @NotNull
    @ManyToOne
    private Empresa empresa;

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
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String celular;

    /**
     */
    @NotNull
    private String username;

    /**
     */
    private String password;

    /**
     */
    @NotNull
    @ManyToOne
    private Rol rol;

    /**
     */
    private int numeroIntentos;

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
