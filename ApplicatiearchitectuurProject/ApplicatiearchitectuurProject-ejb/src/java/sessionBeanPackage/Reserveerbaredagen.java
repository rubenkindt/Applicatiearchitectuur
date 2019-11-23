/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "reserveerbaredagen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserveerbaredagen.findAll", query = "SELECT r FROM Reserveerbaredagen r"),
    @NamedQuery(name = "Reserveerbaredagen.findByDatum", query = "SELECT r FROM Reserveerbaredagen r WHERE r.datum = :datum"),
    @NamedQuery(name = "Reserveerbaredagen.findByOid", query = "SELECT r FROM Reserveerbaredagen r WHERE r.oid = :oid")})
public class Reserveerbaredagen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Column(name = "oid")
    private Integer oid;
    @JoinColumns({
        @JoinColumn(name = "serieNr", referencedColumnName = "serieNr"),
        @JoinColumn(name = "serieNr", referencedColumnName = "serieNr")})
    @ManyToOne
    private Machine machine;

    public Reserveerbaredagen() {
    }

    public Reserveerbaredagen(Date datum) {
        this.datum = datum;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datum != null ? datum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserveerbaredagen)) {
            return false;
        }
        Reserveerbaredagen other = (Reserveerbaredagen) object;
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sessionBeanPackage.Reserveerbaredagen[ datum=" + datum + " ]";
    }
    
}
