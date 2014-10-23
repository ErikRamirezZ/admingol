// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.domain;

import com.raze.admingol.catalog.StatusPartido;
import com.raze.admingol.catalog.TipoPartido;
import com.raze.admingol.domain.Cancha;
import com.raze.admingol.domain.Equipo;
import com.raze.admingol.domain.Horario;
import com.raze.admingol.domain.Partido;
import com.raze.admingol.domain.Torneo;
import com.raze.admingol.domain.Usuario;
import java.util.Date;
import java.util.Set;

privileged aspect Partido_Roo_JavaBean {
    
    public Cancha Partido.getCancha() {
        return this.cancha;
    }
    
    public void Partido.setCancha(Cancha cancha) {
        this.cancha = cancha;
    }
    
    public Set<Usuario> Partido.getArbitros() {
        return this.arbitros;
    }
    
    public void Partido.setArbitros(Set<Usuario> arbitros) {
        this.arbitros = arbitros;
    }
    
    public Torneo Partido.getTorneoEquipoLocal() {
        return this.torneoEquipoLocal;
    }
    
    public void Partido.setTorneoEquipoLocal(Torneo torneoEquipoLocal) {
        this.torneoEquipoLocal = torneoEquipoLocal;
    }
    
    public Equipo Partido.getEquipoLocal() {
        return this.equipoLocal;
    }
    
    public void Partido.setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    
    public Torneo Partido.getTorneoEquipoVisitante() {
        return this.torneoEquipoVisitante;
    }
    
    public void Partido.setTorneoEquipoVisitante(Torneo torneoEquipoVisitante) {
        this.torneoEquipoVisitante = torneoEquipoVisitante;
    }
    
    public Equipo Partido.getEquipoVisitante() {
        return this.equipoVisitante;
    }
    
    public void Partido.setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    
    public Date Partido.getFechaJuego() {
        return this.fechaJuego;
    }
    
    public void Partido.setFechaJuego(Date fechaJuego) {
        this.fechaJuego = fechaJuego;
    }
    
    public Horario Partido.getHorario() {
        return this.horario;
    }
    
    public void Partido.setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public TipoPartido Partido.getTipoPartido() {
        return this.tipoPartido;
    }
    
    public void Partido.setTipoPartido(TipoPartido tipoPartido) {
        this.tipoPartido = tipoPartido;
    }
    
    public StatusPartido Partido.getStatus() {
        return this.status;
    }
    
    public void Partido.setStatus(StatusPartido status) {
        this.status = status;
    }
    
    public Usuario Partido.getUsuario() {
        return this.usuario;
    }
    
    public void Partido.setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public Date Partido.getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void Partido.setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public Date Partido.getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void Partido.setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}