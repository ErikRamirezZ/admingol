package com.raze.admingol.domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Rol implements GrantedAuthority {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toJson() {
		return new JSONSerializer().exclude("*.class").deepSerialize(this);
	}

	public String toJson(String[] fields) {
		return new JSONSerializer().include(fields).exclude("*.class")
				.deepSerialize(this);
	}

	public static Rol fromJsonToRol(String json) {
		return new JSONDeserializer<Rol>().use(null, Rol.class).deserialize(
				json);
	}

	public static String toJsonArray(Collection<Rol> collection) {
		return new JSONSerializer().exclude("*.class")
				.deepSerialize(collection);
	}

	public static String toJsonArray(Collection<Rol> collection, String[] fields) {
		return new JSONSerializer().include(fields).exclude("*.class")
				.deepSerialize(collection);
	}

	public static Collection<Rol> fromJsonArrayToRols(String json) {
		return new JSONDeserializer<List<Rol>>().use("values", Rol.class)
				.deserialize(json);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	private String nombre;

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
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public String getAuthority() {
		return nombre;
	}
}
