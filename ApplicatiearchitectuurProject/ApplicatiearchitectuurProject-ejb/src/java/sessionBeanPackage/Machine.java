/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m"),
    @NamedQuery(name = "Machine.findByLokaal", query = "SELECT m FROM Machine m WHERE m.lokaal = :lokaal"),
    @NamedQuery(name = "Machine.findByMnaam", query = "SELECT m FROM Machine m WHERE m.mnaam = :mnaam"),
    @NamedQuery(name = "Machine.findBySerieNr", query = "SELECT m FROM Machine m WHERE m.serieNr = :serieNr"),
    @NamedQuery(name = "Machine.findByHuurprijs", query = "SELECT m FROM Machine m WHERE m.huurprijs = :huurprijs"),
    @NamedQuery(name = "Machine.findByAankoopprijs", query = "SELECT m FROM Machine m WHERE m.aankoopprijs = :aankoopprijs")})
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "lokaal")
    private String lokaal;
    @Lob
    @Size(max = 65535)
    @Column(name = "omschrijving")
    private String omschrijving;
    @Size(max = 20)
    @Column(name = "mnaam")
    private String mnaam;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "serieNr")
    private String serieNr;
    @Column(name = "huurprijs")
    private Integer huurprijs;
    @Column(name = "aankoopprijs")
    private Integer aankoopprijs;
    @JoinColumns({
        @JoinColumn(name = "oid", referencedColumnName = "oid"),
        @JoinColumn(name = "oid", referencedColumnName = "oid")})
    @ManyToOne
    private Opleiding opleiding;
    @OneToMany(mappedBy = "machine")
    private Collection<Reserveerbaredagen> reserveerbaredagenCollection;
    @OneToMany(mappedBy = "machine")
    private Collection<Reservatie> reservatieCollection;

    public Machine() {
    }

    public Machine(String serieNr) {
        this.serieNr = serieNr;
    }

    public String getLokaal() {
        return lokaal;
    }

    public void setLokaal(String lokaal) {
        this.lokaal = lokaal;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getMnaam() {
        return mnaam;
    }

    public void setMnaam(String mnaam) {
        this.mnaam = mnaam;
    }

    public String getSerieNr() {
        return serieNr;
    }

    public void setSerieNr(String serieNr) {
        this.serieNr = serieNr;
    }

    public Integer getHuurprijs() {
        return huurprijs;
    }

    public void setHuurprijs(Integer huurprijs) {
        this.huurprijs = huurprijs;
    }

    public Integer getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(Integer aankoopprijs) {
        this.aankoopprijs = aankoopprijs;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }

    @XmlTransient
    public Collection<Reserveerbaredagen> getReserveerbaredagenCollection() {
        return reserveerbaredagenCollection;
    }

    public void setReserveerbaredagenCollection(Collection<Reserveerbaredagen> reserveerbaredagenCollection) {
        this.reserveerbaredagenCollection = reserveerbaredagenCollection;
    }

    @XmlTransient
    public Collection<Reservatie> getReservatieCollection() {
        return reservatieCollection;
    }

    public void setReservatieCollection(Collection<Reservatie> reservatieCollection) {
        this.reservatieCollection = reservatieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serieNr != null ? serieNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.serieNr == null && other.serieNr != null) || (this.serieNr != null && !this.serieNr.equals(other.serieNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sessionBeanPackage.Machine[ serieNr=" + serieNr + " ]";
    }
    
}
