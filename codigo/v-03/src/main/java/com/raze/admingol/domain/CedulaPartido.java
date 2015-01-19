package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
import com.raze.admingol.catalog.StatusCedula;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.Enumerated;

@Entity
public class CedulaPartido {

    /**
     */
    @NotNull
    @ManyToOne
    private Partido partido;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date horaInicioReal;

    /**
     */
    private int marcadorEquipoLocal;

    /**
     */
    private int marcadorEquipoVisitante;

    /**
     */
    private String observaciones;

    /**
     */
    @NotNull
    @Enumerated
    private StatusCedula status;

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

	public static CedulaPartido fromJsonToCedulaPartido(String json) {
        return new JSONDeserializer<CedulaPartido>()
        .use(null, CedulaPartido.class).deserialize(json);
    }

	public static String toJsonArray(Collection<CedulaPartido> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<CedulaPartido> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<CedulaPartido> fromJsonArrayToCedulaPartidoes(String json) {
        return new JSONDeserializer<List<CedulaPartido>>()
        .use("values", CedulaPartido.class).deserialize(json);
    }

	public Partido getPartido() {
        return this.partido;
    }

	public void setPartido(Partido partido) {
        this.partido = partido;
    }

	public Date getHoraInicioReal() {
        return this.horaInicioReal;
    }

	public void setHoraInicioReal(Date horaInicioReal) {
        this.horaInicioReal = horaInicioReal;
    }

	public int getMarcadorEquipoLocal() {
        return this.marcadorEquipoLocal;
    }

	public void setMarcadorEquipoLocal(int marcadorEquipoLocal) {
        this.marcadorEquipoLocal = marcadorEquipoLocal;
    }

	public int getMarcadorEquipoVisitante() {
        return this.marcadorEquipoVisitante;
    }

	public void setMarcadorEquipoVisitante(int marcadorEquipoVisitante) {
        this.marcadorEquipoVisitante = marcadorEquipoVisitante;
    }

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

	public StatusCedula getStatus() {
        return this.status;
    }

	public void setStatus(StatusCedula status) {
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
