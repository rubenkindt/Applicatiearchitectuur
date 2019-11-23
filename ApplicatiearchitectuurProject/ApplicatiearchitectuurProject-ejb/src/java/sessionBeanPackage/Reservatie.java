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
@Table(name = "reservatie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservatie.findAll", query = "SELECT r FROM Reservatie r"),
    @NamedQuery(name = "Reservatie.findByRid", query = "SELECT r FROM Reservatie r WHERE r.rid = :rid"),
    @NamedQuery(name = "Reservatie.findByDatum", query = "SELECT r FROM Reservatie r WHERE r.datum = :datum"),
    @NamedQuery(name = "Reservatie.findByOid", query = "SELECT r FROM Reservatie r WHERE r.oid = :oid")})
public class Reservatie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "rid")
    private Integer rid;
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

    public Reservatie() {
    }

    public Reservatie(Integer rid) {
        this.rid = rid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservatie)) {
            return false;
        }
        Reservatie other = (Reservatie) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sessionBeanPackage.Reservatie[ rid=" + rid + " ]";
    }
    
}
