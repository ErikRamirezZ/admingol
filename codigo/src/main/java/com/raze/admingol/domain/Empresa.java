package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(finders = { "findEmpresasByActivo", "findEmpresasByNombreComercialLikeAndActivo", "findEmpresasByNombreLikeAndActivo" })
@RooJson(deepSerialize = true)
public class Empresa {

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    private String nombreComercial;

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
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] logo;

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
