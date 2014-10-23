// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.catalog;

import com.raze.admingol.catalog.StatusEquipoJugador;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect StatusEquipoJugador_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager StatusEquipoJugador.entityManager;
    
    public static final List<String> StatusEquipoJugador.fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombreStatusEquipoJugador", "descripcion", "activo", "usuario", "fechaCreacion", "fechaModificacion");
    
    public static final EntityManager StatusEquipoJugador.entityManager() {
        EntityManager em = new StatusEquipoJugador().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long StatusEquipoJugador.countStatusEquipoJugadors() {
        return entityManager().createQuery("SELECT COUNT(o) FROM StatusEquipoJugador o", Long.class).getSingleResult();
    }
    
    public static List<StatusEquipoJugador> StatusEquipoJugador.findAllStatusEquipoJugadors() {
        return entityManager().createQuery("SELECT o FROM StatusEquipoJugador o", StatusEquipoJugador.class).getResultList();
    }
    
    public static List<StatusEquipoJugador> StatusEquipoJugador.findAllStatusEquipoJugadors(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusEquipoJugador o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusEquipoJugador.class).getResultList();
    }
    
    public static StatusEquipoJugador StatusEquipoJugador.findStatusEquipoJugador(Long id) {
        if (id == null) return null;
        return entityManager().find(StatusEquipoJugador.class, id);
    }
    
    public static List<StatusEquipoJugador> StatusEquipoJugador.findStatusEquipoJugadorEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM StatusEquipoJugador o", StatusEquipoJugador.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<StatusEquipoJugador> StatusEquipoJugador.findStatusEquipoJugadorEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusEquipoJugador o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusEquipoJugador.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void StatusEquipoJugador.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void StatusEquipoJugador.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            StatusEquipoJugador attached = StatusEquipoJugador.findStatusEquipoJugador(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void StatusEquipoJugador.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void StatusEquipoJugador.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public StatusEquipoJugador StatusEquipoJugador.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        StatusEquipoJugador merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}