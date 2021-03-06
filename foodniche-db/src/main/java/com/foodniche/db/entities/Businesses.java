/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodniche.db.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Entity
@Table(name = "businesses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Businesses.findAll", query = "SELECT b FROM Businesses b"),
    @NamedQuery(name = "Businesses.findByBusinessid", query = "SELECT b FROM Businesses b WHERE b.businessid = :businessid"),
    @NamedQuery(name = "Businesses.findByName", query = "SELECT b FROM Businesses b WHERE b.name = :name"),
    @NamedQuery(name = "Businesses.findByWebsite", query = "SELECT b FROM Businesses b WHERE b.website = :website"),
    @NamedQuery(name = "Businesses.findByDescription", query = "SELECT b FROM Businesses b WHERE b.description = :description")})
public class Businesses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "businessid")
    private Integer businessid;

    @ManyToOne
    @JoinColumn(name = "businesstypeid")
    private Businesstypes businessType;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @Size(max = 80)
    @Column(name = "name")
    private String name;
    @Size(max = 80)
    @Column(name = "zipcode")
    private String zipCode;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;

    public Businesses() {
    }

    public Businesses(Integer businessid) {
        this.businessid = businessid;
    }

    public Integer getBusinessid() {
        return businessid;
    }

    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }

    public Businesstypes getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Businesstypes businessType) {
        this.businessType = businessType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipcode) {
        this.zipCode = zipcode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (businessid != null ? businessid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businesses)) {
            return false;
        }
        Businesses other = (Businesses) object;
        if ((this.businessid == null && other.businessid != null) || (this.businessid != null && !this.businessid.equals(other.businessid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.foodnicherest.Businesses[ businessid=" + businessid + " ]";
    }
    
}
