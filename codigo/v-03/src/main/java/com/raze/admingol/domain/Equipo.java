package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;
import javax.persistence.Version;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import com.raze.admingol.catalog.StatusEquipoJugador;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.Enumerated;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity
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
    @ManyToOne
    private Torneo torneo;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] logo;

    /**
     */
    @Enumerated
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

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getNombreCorto() {
        return this.nombreCorto;
    }

	public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

	public Torneo getTorneo() {
        return this.torneo;
    }

	public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

	public byte[] getLogo() {
        return this.logo;
    }

	public void setLogo(byte[] logo) {
        this.logo = logo;
    }

	public StatusEquipoJugador getStatus() {
        return this.status;
    }

	public void setStatus(StatusEquipoJugador status) {
        this.status = status;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Equipo fromJsonToEquipo(String json) {
        return new JSONDeserializer<Equipo>()
        .use(null, Equipo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Equipo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Equipo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Equipo> fromJsonArrayToEquipoes(String json) {
        return new JSONDeserializer<List<Equipo>>()
        .use("values", Equipo.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
