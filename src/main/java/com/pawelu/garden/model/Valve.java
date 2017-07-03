/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawelu.garden.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author epawura
 */
@Entity
@Table(name = "valve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valve.findAll", query = "SELECT v FROM Valve v")
    , @NamedQuery(name = "Valve.findById", query = "SELECT v FROM Valve v WHERE v.id = :id")
    , @NamedQuery(name = "Valve.findByDatee", query = "SELECT v FROM Valve v WHERE v.datee = :datee")
    , @NamedQuery(name = "Valve.findByValve", query = "SELECT v FROM Valve v WHERE v.valve = :valve")})
public class Valve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datee")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datee;
    @Column(name = "valve")
    private Integer valve;

    public Valve() {
    }

    public Valve(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatee() {
        return datee;
    }

    public void setDatee(Date datee) {
        this.datee = datee;
    }

    public Integer getValve() {
        return valve;
    }

    public void setValve(Integer valve) {
        this.valve = valve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valve)) {
            return false;
        }
        Valve other = (Valve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pawelu.garden.model.Valve[ id=" + id + " ]";
    }
    
}
