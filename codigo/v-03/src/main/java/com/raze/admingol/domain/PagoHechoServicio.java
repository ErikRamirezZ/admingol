package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
public class PagoHechoServicio {

    /**
     */
    @NotNull
    @ManyToOne
    private ControlPagoServicio controlPagoServicio;

    /**
     */
    @NotNull
    private double monto;

    /**
     */
    private int descuento;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaPago;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaVencimiento;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static PagoHechoServicio fromJsonToPagoHechoServicio(String json) {
        return new JSONDeserializer<PagoHechoServicio>()
        .use(null, PagoHechoServicio.class).deserialize(json);
    }

	public static String toJsonArray(Collection<PagoHechoServicio> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<PagoHechoServicio> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<PagoHechoServicio> fromJsonArrayToPagoHechoServicios(String json) {
        return new JSONDeserializer<List<PagoHechoServicio>>()
        .use("values", PagoHechoServicio.class).deserialize(json);
    }

	public ControlPagoServicio getControlPagoServicio() {
        return this.controlPagoServicio;
    }

	public void setControlPagoServicio(ControlPagoServicio controlPagoServicio) {
        this.controlPagoServicio = controlPagoServicio;
    }

	public double getMonto() {
        return this.monto;
    }

	public void setMonto(double monto) {
        this.monto = monto;
    }

	public int getDescuento() {
        return this.descuento;
    }

	public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

	public Date getFechaPago() {
        return this.fechaPago;
    }

	public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

	public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

	public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
}
