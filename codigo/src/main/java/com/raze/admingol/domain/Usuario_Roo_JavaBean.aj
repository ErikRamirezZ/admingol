// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.domain;

import com.raze.admingol.catalog.Rol;
import com.raze.admingol.domain.Empresa;
import com.raze.admingol.domain.Usuario;
import java.util.Date;

privileged aspect Usuario_Roo_JavaBean {
    
    public Empresa Usuario.getEmpresa() {
        return this.empresa;
    }
    
    public void Usuario.setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public String Usuario.getNombre() {
        return this.nombre;
    }
    
    public void Usuario.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Usuario.getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void Usuario.setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    
    public String Usuario.getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void Usuario.setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
    public Date Usuario.getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void Usuario.setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String Usuario.getDomicilio() {
        return this.domicilio;
    }
    
    public void Usuario.setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public String Usuario.getTelefono() {
        return this.telefono;
    }
    
    public void Usuario.setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String Usuario.getCelular() {
        return this.celular;
    }
    
    public void Usuario.setCelular(String celular) {
        this.celular = celular;
    }
    
    public String Usuario.getUsername() {
        return this.username;
    }
    
    public void Usuario.setUsername(String username) {
        this.username = username;
    }
    
    public String Usuario.getPassword() {
        return this.password;
    }
    
    public void Usuario.setPassword(String password) {
        this.password = password;
    }
    
    public Rol Usuario.getRol() {
        return this.rol;
    }
    
    public void Usuario.setRol(Rol rol) {
        this.rol = rol;
    }
    
    public int Usuario.getNumeroIntentos() {
        return this.numeroIntentos;
    }
    
    public void Usuario.setNumeroIntentos(int numeroIntentos) {
        this.numeroIntentos = numeroIntentos;
    }
    
    public Boolean Usuario.getActivo() {
        return this.activo;
    }
    
    public void Usuario.setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    public Usuario Usuario.getUsuario() {
        return this.usuario;
    }
    
    public void Usuario.setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date Usuario.getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void Usuario.setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public Date Usuario.getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void Usuario.setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}