// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.domain;

import com.raze.admingol.domain.Horario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Horario_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Horario.entityManager;
    
    public static final List<String> Horario.fieldNames4OrderClauseFilter = java.util.Arrays.asList("cancha", "horaInicio", "duracion", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo", "activo", "usuario", "fechaCreacion", "fechaModificacion");
    
    public static final EntityManager Horario.entityManager() {
        EntityManager em = new Horario().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Horario.countHorarios() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Horario o", Long.class).getSingleResult();
    }
    
    public static List<Horario> Horario.findAllHorarios() {
        return entityManager().createQuery("SELECT o FROM Horario o", Horario.class).getResultList();
    }
    
    public static List<Horario> Horario.findAllHorarios(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Horario o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Horario.class).getResultList();
    }
    
    public static Horario Horario.findHorario(Long id) {
        if (id == null) return null;
        return entityManager().find(Horario.class, id);
    }
    
    public static List<Horario> Horario.findHorarioEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Horario o", Horario.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Horario> Horario.findHorarioEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Horario o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Horario.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Horario.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Horario.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Horario attached = Horario.findHorario(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Horario.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Horario.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Horario Horario.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Horario merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}