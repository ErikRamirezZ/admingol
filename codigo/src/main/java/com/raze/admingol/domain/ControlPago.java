package com.raze.admingol.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.admingol.catalog.TipoTarjeta;
import com.raze.admingol.catalog.FechaVencimientoTC;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson(deepSerialize = true)
public class ControlPago {

    /**
     */
    @NotNull
    @ManyToOne
    private Empresa empresa;

    /**
     */
    @NotNull
    private double tarifa;

    /**
     */
    private int cuenta;

    /**
     */
    private int noReferencia;

    /**
     */
    @ManyToOne
    private TipoTarjeta tipoTarjeta;

    /**
     */
    private int noTC;

    /**
     */
    private int codigoSeguridad;

    /**
     */
    @ManyToOne
    private FechaVencimientoTC fechaVencimientoTC;

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
