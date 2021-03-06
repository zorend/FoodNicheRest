/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodniche.db.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Entity
@Table(name = "businesstypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businesstypes.findAll", query = "SELECT b FROM Businesstypes b"),
    @NamedQuery(name = "Businesstypes.findByBusinesstypeid", query = "SELECT b FROM Businesstypes b WHERE b.businesstypeid = :businesstypeid"),
    @NamedQuery(name = "Businesstypes.findByName", query = "SELECT b FROM Businesstypes b WHERE b.name = :name")})
public class Businesstypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "businesstypeid")
    private Integer businesstypeid;
    @Size(max = 80)
    @Column(name = "name")
    private String name;

    public Businesstypes() {
    }

    public Businesstypes(Integer businesstypeid) {
        this.businesstypeid = businesstypeid;
    }

    public Integer getBusinesstypeid() {
        return businesstypeid;
    }

    public void setBusinesstypeid(Integer businesstypeid) {
        this.businesstypeid = businesstypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businesstypeid != null ? businesstypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businesstypes)) {
            return false;
        }
        Businesstypes other = (Businesstypes) object;
        if ((this.businesstypeid == null && other.businesstypeid != null) || (this.businesstypeid != null && !this.businesstypeid.equals(other.businesstypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.foodnicherest.Businesstypes[ businesstypeid=" + businesstypeid + " ]";
    }
    
}
