package com.raze.admingol.domain;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.raze.admingol.catalog.Posicion;
import com.raze.admingol.catalog.StatusEquipoJugador;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Jugador {

    /**
     */
    @NotNull
    @ManyToOne
    private Equipo equipo;

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    private String apellidoPaterno;

    /**
     */
    private String apellidoMaterno;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaNacimiento;

    /**
     */
    @Lob
    private byte[] foto;

    /**
     */
    private String domicilio;

    /**
     */
    private String telefono;

    /**
     */
    private String correoE;

    /**
     */
    private Boolean esDelegado;

    /**
     */
    @Enumerated
    private Posicion posicion;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Jugador fromJsonToJugador(String json) {
        return new JSONDeserializer<Jugador>()
        .use(null, Jugador.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Jugador> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Jugador> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Jugador> fromJsonArrayToJugadors(String json) {
        return new JSONDeserializer<List<Jugador>>()
        .use("values", Jugador.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Equipo getEquipo() {
        return this.equipo;
    }

	public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

	public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

	public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

	public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

	public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

	public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

	public byte[] getFoto() {
        return this.foto;
    }

	public void setFoto(byte[] foto) {
        this.foto = foto;
    }

	public String getDomicilio() {
        return this.domicilio;
    }

	public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

	public String getTelefono() {
        return this.telefono;
    }

	public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	public String getCorreoE() {
        return this.correoE;
    }

	public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

	public Boolean getEsDelegado() {
        return this.esDelegado;
    }

	public void setEsDelegado(Boolean esDelegado) {
        this.esDelegado = esDelegado;
    }

	public Posicion getPosicion() {
        return this.posicion;
    }

	public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
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
}
