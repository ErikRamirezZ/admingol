package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import com.raze.admingol.catalog.TipoPartido;
import javax.persistence.Enumerated;
import com.raze.admingol.catalog.StatusPartido;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
public class Partido {

    /**
     */
    @NotNull
    @ManyToOne
    private Cancha cancha;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> arbitros = new ArrayList<Usuario>();

    /**
     */
    @ManyToOne
    private Torneo torneoEquipoLocal;

    /**
     */
    @ManyToOne
    private Equipo equipoLocal;

    /**
     */
    @ManyToOne
    private Torneo torneoEquipoVisitante;

    /**
     */
    @ManyToOne
    private Equipo equipoVisitante;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaJuego;

    /**
     */
    @ManyToOne
    private Horario horario;

    /**
     */
    @Enumerated
    private TipoPartido tipoPartido;

    /**
     */
    @NotNull
    @Enumerated
    private StatusPartido status;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Partido fromJsonToPartido(String json) {
        return new JSONDeserializer<Partido>()
        .use(null, Partido.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Partido> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Partido> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Partido> fromJsonArrayToPartidoes(String json) {
        return new JSONDeserializer<List<Partido>>()
        .use("values", Partido.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Cancha getCancha() {
        return this.cancha;
    }

	public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

	public List<Usuario> getArbitros() {
        return this.arbitros;
    }

	public void setArbitros(List<Usuario> arbitros) {
        this.arbitros = arbitros;
    }

	public Torneo getTorneoEquipoLocal() {
        return this.torneoEquipoLocal;
    }

	public void setTorneoEquipoLocal(Torneo torneoEquipoLocal) {
        this.torneoEquipoLocal = torneoEquipoLocal;
    }

	public Equipo getEquipoLocal() {
        return this.equipoLocal;
    }

	public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

	public Torneo getTorneoEquipoVisitante() {
        return this.torneoEquipoVisitante;
    }

	public void setTorneoEquipoVisitante(Torneo torneoEquipoVisitante) {
        this.torneoEquipoVisitante = torneoEquipoVisitante;
    }

	public Equipo getEquipoVisitante() {
        return this.equipoVisitante;
    }

	public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

	public Date getFechaJuego() {
        return this.fechaJuego;
    }

	public void setFechaJuego(Date fechaJuego) {
        this.fechaJuego = fechaJuego;
    }

	public Horario getHorario() {
        return this.horario;
    }

	public void setHorario(Horario horario) {
        this.horario = horario;
    }

	public TipoPartido getTipoPartido() {
        return this.tipoPartido;
    }

	public void setTipoPartido(TipoPartido tipoPartido) {
        this.tipoPartido = tipoPartido;
    }

	public StatusPartido getStatus() {
        return this.status;
    }

	public void setStatus(StatusPartido status) {
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
