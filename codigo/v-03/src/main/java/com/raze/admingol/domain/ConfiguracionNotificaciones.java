package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.raze.admingol.catalog.ViaNotificacion;
import javax.persistence.Enumerated;
import com.raze.admingol.catalog.PerodoNotificacion;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.ManyToOne;

@Entity
public class ConfiguracionNotificaciones {

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     */
    @NotNull
    private String mensaje;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fecha_hora;

    /**
     */
    @NotNull
    @Enumerated
    private ViaNotificacion viaNotificacion;

    /**
     */
    @Enumerated
    private PerodoNotificacion repetir;

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

	public static ConfiguracionNotificaciones fromJsonToConfiguracionNotificaciones(String json) {
        return new JSONDeserializer<ConfiguracionNotificaciones>()
        .use(null, ConfiguracionNotificaciones.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ConfiguracionNotificaciones> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ConfiguracionNotificaciones> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ConfiguracionNotificaciones> fromJsonArrayToConfiguracionNotificacioneses(String json) {
        return new JSONDeserializer<List<ConfiguracionNotificaciones>>()
        .use("values", ConfiguracionNotificaciones.class).deserialize(json);
    }

	public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

	public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

	public String getMensaje() {
        return this.mensaje;
    }

	public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

	public Date getFecha_hora() {
        return this.fecha_hora;
    }

	public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

	public ViaNotificacion getViaNotificacion() {
        return this.viaNotificacion;
    }

	public void setViaNotificacion(ViaNotificacion viaNotificacion) {
        this.viaNotificacion = viaNotificacion;
    }

	public PerodoNotificacion getRepetir() {
        return this.repetir;
    }

	public void setRepetir(PerodoNotificacion repetir) {
        this.repetir = repetir;
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
}
