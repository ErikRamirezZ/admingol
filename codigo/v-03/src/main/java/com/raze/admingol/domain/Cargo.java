package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import com.raze.admingol.catalog.ConceptoCobro;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
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
public class Cargo {

    /**
     */
    @NotNull
    @Enumerated
    private ConceptoCobro conceptoCobro;

    /**
     */
    @NotNull
    @ManyToOne
    private Torneo torneo;

    /**
     */
    @NotNull
    @ManyToOne
    private Equipo equipo;

    /**
     */
    @NotNull
    private double monto;

    /**
     */
    private String observaciones;

    /**
     */
    @Enumerated
    private StatusCargoAbono status;

    /**
     */
    @ManyToOne
    private Abono abono;

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

	public ConceptoCobro getConceptoCobro() {
        return this.conceptoCobro;
    }

	public void setConceptoCobro(ConceptoCobro conceptoCobro) {
        this.conceptoCobro = conceptoCobro;
    }

	public Torneo getTorneo() {
        return this.torneo;
    }

	public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

	public Equipo getEquipo() {
        return this.equipo;
    }

	public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

	public double getMonto() {
        return this.monto;
    }

	public void setMonto(double monto) {
        this.monto = monto;
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

	public Abono getAbono() {
        return this.abono;
    }

	public void setAbono(Abono abono) {
        this.abono = abono;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Cargo fromJsonToCargo(String json) {
        return new JSONDeserializer<Cargo>()
        .use(null, Cargo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Cargo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Cargo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Cargo> fromJsonArrayToCargoes(String json) {
        return new JSONDeserializer<List<Cargo>>()
        .use("values", Cargo.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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
