package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.admingol.catalog.TipoTarjeta;
import javax.persistence.Enumerated;
import com.raze.admingol.catalog.FechaVencimientoTC;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ControlPagoServicio {

    /**
     */
    @NotNull
    @ManyToOne
    private Empresa empresa;

    /**
     */
    @NotNull
    private double tarfa;

    /**
     */
    private int cuenta;

    /**
     */
    private int noReferencia;

    /**
     */
    @Enumerated
    private TipoTarjeta tipoTarjeta;

    /**
     */
    private int noTC;

    /**
     */
    private int codigoSeguridad;

    /**
     */
    @Enumerated
    private FechaVencimientoTC fechaVencimientoTC;

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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Empresa getEmpresa() {
        return this.empresa;
    }

	public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public double getTarfa() {
        return this.tarfa;
    }

	public void setTarfa(double tarfa) {
        this.tarfa = tarfa;
    }

	public int getCuenta() {
        return this.cuenta;
    }

	public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

	public int getNoReferencia() {
        return this.noReferencia;
    }

	public void setNoReferencia(int noReferencia) {
        this.noReferencia = noReferencia;
    }

	public TipoTarjeta getTipoTarjeta() {
        return this.tipoTarjeta;
    }

	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

	public int getNoTC() {
        return this.noTC;
    }

	public void setNoTC(int noTC) {
        this.noTC = noTC;
    }

	public int getCodigoSeguridad() {
        return this.codigoSeguridad;
    }

	public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

	public FechaVencimientoTC getFechaVencimientoTC() {
        return this.fechaVencimientoTC;
    }

	public void setFechaVencimientoTC(FechaVencimientoTC fechaVencimientoTC) {
        this.fechaVencimientoTC = fechaVencimientoTC;
    }

	public Boolean getActivo() {
        return this.activo;
    }

	public void setActivo(Boolean activo) {
        this.activo = activo;
    }

	public Usuario getUsuario() {
        return this.usuario;
    }

	public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

	public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

	public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

	public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static ControlPagoServicio fromJsonToControlPagoServicio(String json) {
        return new JSONDeserializer<ControlPagoServicio>()
        .use(null, ControlPagoServicio.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ControlPagoServicio> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ControlPagoServicio> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ControlPagoServicio> fromJsonArrayToControlPagoServicios(String json) {
        return new JSONDeserializer<List<ControlPagoServicio>>()
        .use("values", ControlPagoServicio.class).deserialize(json);
    }
}
