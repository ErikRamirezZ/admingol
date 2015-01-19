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
public class Horario {

    /**
     */
    @NotNull
    @ManyToOne
    private Cancha cancha;

    /**
     */
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date horaInicio;

    /**
     */
    private int duracion;

    /**
     */
    private Boolean lunes;

    /**
     */
    private Boolean martes;

    /**
     */
    private Boolean miercoles;

    /**
     */
    private Boolean jueves;

    /**
     */
    private Boolean viernes;

    /**
     */
    private Boolean sabado;

    /**
     */
    private Boolean domingo;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Horario fromJsonToHorario(String json) {
        return new JSONDeserializer<Horario>()
        .use(null, Horario.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Horario> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Horario> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Horario> fromJsonArrayToHorarios(String json) {
        return new JSONDeserializer<List<Horario>>()
        .use("values", Horario.class).deserialize(json);
    }

	public Cancha getCancha() {
        return this.cancha;
    }

	public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

	public Date getHoraInicio() {
        return this.horaInicio;
    }

	public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

	public int getDuracion() {
        return this.duracion;
    }

	public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

	public Boolean getLunes() {
        return this.lunes;
    }

	public void setLunes(Boolean lunes) {
        this.lunes = lunes;
    }

	public Boolean getMartes() {
        return this.martes;
    }

	public void setMartes(Boolean martes) {
        this.martes = martes;
    }

	public Boolean getMiercoles() {
        return this.miercoles;
    }

	public void setMiercoles(Boolean miercoles) {
        this.miercoles = miercoles;
    }

	public Boolean getJueves() {
        return this.jueves;
    }

	public void setJueves(Boolean jueves) {
        this.jueves = jueves;
    }

	public Boolean getViernes() {
        return this.viernes;
    }

	public void setViernes(Boolean viernes) {
        this.viernes = viernes;
    }

	public Boolean getSabado() {
        return this.sabado;
    }

	public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

	public Boolean getDomingo() {
        return this.domingo;
    }

	public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
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
