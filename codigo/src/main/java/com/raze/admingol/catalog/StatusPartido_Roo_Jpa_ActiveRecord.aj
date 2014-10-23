// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.catalog;

import com.raze.admingol.catalog.StatusPartido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect StatusPartido_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager StatusPartido.entityManager;
    
    public static final List<String> StatusPartido.fieldNames4OrderClauseFilter = java.util.Arrays.asList("nombreStatusPartido", "descripcion", "activo", "usuario", "fechaCreacion", "fechaModificacion");
    
    public static final EntityManager StatusPartido.entityManager() {
        EntityManager em = new StatusPartido().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long StatusPartido.countStatusPartidoes() {
        return entityManager().createQuery("SELECT COUNT(o) FROM StatusPartido o", Long.class).getSingleResult();
    }
    
    public static List<StatusPartido> StatusPartido.findAllStatusPartidoes() {
        return entityManager().createQuery("SELECT o FROM StatusPartido o", StatusPartido.class).getResultList();
    }
    
    public static List<StatusPartido> StatusPartido.findAllStatusPartidoes(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusPartido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusPartido.class).getResultList();
    }
    
    public static StatusPartido StatusPartido.findStatusPartido(Long id) {
        if (id == null) return null;
        return entityManager().find(StatusPartido.class, id);
    }
    
    public static List<StatusPartido> StatusPartido.findStatusPartidoEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM StatusPartido o", StatusPartido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<StatusPartido> StatusPartido.findStatusPartidoEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM StatusPartido o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, StatusPartido.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void StatusPartido.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void StatusPartido.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            StatusPartido attached = StatusPartido.findStatusPartido(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void StatusPartido.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void StatusPartido.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public StatusPartido StatusPartido.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        StatusPartido merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}