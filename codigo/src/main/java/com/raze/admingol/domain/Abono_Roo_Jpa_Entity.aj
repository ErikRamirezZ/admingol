// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.domain;

import com.raze.admingol.domain.Abono;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Abono_Roo_Jpa_Entity {
    
    declare @type: Abono: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Abono.id;
    
    @Version
    @Column(name = "version")
    private Integer Abono.version;
    
    public Long Abono.getId() {
        return this.id;
    }
    
    public void Abono.setId(Long id) {
        this.id = id;
    }
    
    public Integer Abono.getVersion() {
        return this.version;
    }
    
    public void Abono.setVersion(Integer version) {
        this.version = version;
    }
    
}