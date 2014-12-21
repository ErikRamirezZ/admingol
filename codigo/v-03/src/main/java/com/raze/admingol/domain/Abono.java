package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.admingol.catalog.MetodoPago;
import javax.persistence.Enumerated;
import com.raze.admingol.catalog.Descuento;
import com.raze.admingol.catalog.StatusCargoAbono;
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
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
public class Abono {

    /**
     */
    @NotNull
    @ManyToOne
    private Cargo cargo;

    /**
     */
    @NotNull
    @Enumerated
    private MetodoPago metodoPago;

    /**
     */
    @Enumerated
    private Descuento descuento;

    /**
     */
    private String observaciones;

    /**
     */
    @NotNull
    @Enumerated
    private StatusCargoAbono status;

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

	public static Abono fromJsonToAbono(String json) {
        return new JSONDeserializer<Abono>()
        .use(null, Abono.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Abono> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Abono> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Abono> fromJsonArrayToAbonoes(String json) {
        return new JSONDeserializer<List<Abono>>()
        .use("values", Abono.class).deserialize(json);
    }

	public Cargo getCargo() {
        return this.cargo;
    }

	public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

	public MetodoPago getMetodoPago() {
        return this.metodoPago;
    }

	public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

	public Descuento getDescuento() {
        return this.descuento;
    }

	public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

	public StatusCargoAbono getStatus() {
        return this.status;
    }

	public void setStatus(StatusCargoAbono status) {
        this.status = status;
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
