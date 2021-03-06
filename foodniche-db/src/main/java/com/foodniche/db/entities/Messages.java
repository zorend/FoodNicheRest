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
import java.util.Date;

/**
 *
 * @author User
 */
@Entity
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m"),
    @NamedQuery(name = "Messages.findByMessageid", query = "SELECT m FROM Messages m WHERE m.messageid = :messageid"),
    @NamedQuery(name = "Messages.findByMessagedate", query = "SELECT m FROM Messages m WHERE m.messagedate = :messagedate"),
    @NamedQuery(name = "Messages.findByFromuserid", query = "SELECT m FROM Messages m WHERE m.fromuserid = :fromuserid"),
    @NamedQuery(name = "Messages.findByTouserid", query = "SELECT m FROM Messages m WHERE m.touserid = :touserid"),
    @NamedQuery(name = "Messages.findByContent", query = "SELECT m FROM Messages m WHERE m.content = :content"),
    @NamedQuery(name = "Messages.findByStatus", query = "SELECT m FROM Messages m WHERE m.status = :status")})
public class Messages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "messageid")
    private Integer messageid;
    @Column(name = "messagedate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date messagedate;
    @Column(name = "fromuserid")
    private Integer fromuserid;
    @Column(name = "touserid")
    private Integer touserid;
    @Size(max = 2147483647)
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private Short status;

    public Messages() {
    }

    public Messages(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Date getMessagedate() {
        return messagedate;
    }

    public void setMessagedate(Date messagedate) {
        this.messagedate = messagedate;
    }

    public Integer getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageid != null ? messageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.messageid == null && other.messageid != null) || (this.messageid != null && !this.messageid.equals(other.messageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.foodnicherest.Messages[ messageid=" + messageid + " ]";
    }
    
}
