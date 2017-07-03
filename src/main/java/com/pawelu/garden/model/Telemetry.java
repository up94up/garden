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
@Table(name = "telemetry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telemetry.findAll", query = "SELECT t FROM Telemetry t")
    , @NamedQuery(name = "Telemetry.findById", query = "SELECT t FROM Telemetry t WHERE t.id = :id")
    , @NamedQuery(name = "Telemetry.findByDatee", query = "SELECT t FROM Telemetry t WHERE t.datee = :datee")
    , @NamedQuery(name = "Telemetry.findByTemperature", query = "SELECT t FROM Telemetry t WHERE t.temperature = :temperature")
    , @NamedQuery(name = "Telemetry.findByHumidity", query = "SELECT t FROM Telemetry t WHERE t.humidity = :humidity")
    , @NamedQuery(name = "Telemetry.findBySoilMoisture", query = "SELECT t FROM Telemetry t WHERE t.soilMoisture = :soilMoisture")
    , @NamedQuery(name = "Telemetry.findByRainLevel", query = "SELECT t FROM Telemetry t WHERE t.rainLevel = :rainLevel")
    , @NamedQuery(name = "Telemetry.findByValve", query = "SELECT t FROM Telemetry t WHERE t.valve = :valve")})
public class Telemetry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "datee")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "temperature")
    private Double temperature;
    @Column(name = "humidity")
    private Double humidity;
    @Column(name = "soil_moisture")
    private Integer soilMoisture;
    @Column(name = "rain_level")
    private Integer rainLevel;
    @Column(name = "valve")
    private Integer valve;

    public Telemetry() {
    }

    public Telemetry(Integer id) {
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

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Integer getSoilMoisture() {
        return soilMoisture;
    }

    public void setSoilMoisture(Integer soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    public Integer getRainLevel() {
        return rainLevel;
    }

    public void setRainLevel(Integer rainLevel) {
        this.rainLevel = rainLevel;
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
        if (!(object instanceof Telemetry)) {
            return false;
        }
        Telemetry other = (Telemetry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.pawelu.garden.model.Telemetry[ id=" + id + " ]";
    }
    
}
