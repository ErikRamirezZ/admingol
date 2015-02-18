package com.raze.admingol.domain;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Sucursal {

    /**
     */
    @NotNull
    @ManyToOne
    private Empresa empresa;

    /**
     */
    @NotNull
    private String nombre;

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

	public static Sucursal fromJsonToSucursal(String json) {
        return new JSONDeserializer<Sucursal>()
        .use(null, Sucursal.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Sucursal> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Sucursal> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Sucursal> fromJsonArrayToSucursals(String json) {
        return new JSONDeserializer<List<Sucursal>>()
        .use("values", Sucursal.class).deserialize(json);
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

	public String toString() {
//        return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);
		return nombre + " - " + empresa;
    }

	public Empresa getEmpresa() {
        return this.empresa;
    }

	public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
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
