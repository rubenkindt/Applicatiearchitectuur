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
import javax.persistence.ManyToMany;
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
@Table(name = "opleiding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Opleiding.findAll", query = "SELECT o FROM Opleiding o"),
    @NamedQuery(name = "Opleiding.findByOnaam", query = "SELECT o FROM Opleiding o WHERE o.onaam = :onaam"),
    @NamedQuery(name = "Opleiding.findByOid", query = "SELECT o FROM Opleiding o WHERE o.oid = :oid")})
public class Opleiding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "onaam")
    private String onaam;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "oid")
    private Integer oid;
    @ManyToMany(mappedBy = "opleidingCollection")
    private Collection<Gebruiker> gebruikerCollection;
    @OneToMany(mappedBy = "opleiding")
    private Collection<Machine> machineCollection;

    public Opleiding() {
    }

    public Opleiding(Integer oid) {
        this.oid = oid;
    }

    public String getOnaam() {
        return onaam;
    }

    public void setOnaam(String onaam) {
        this.onaam = onaam;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    @XmlTransient
    public Collection<Gebruiker> getGebruikerCollection() {
        return gebruikerCollection;
    }

    public void setGebruikerCollection(Collection<Gebruiker> gebruikerCollection) {
        this.gebruikerCollection = gebruikerCollection;
    }

    @XmlTransient
    public Collection<Machine> getMachineCollection() {
        return machineCollection;
    }

    public void setMachineCollection(Collection<Machine> machineCollection) {
        this.machineCollection = machineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oid != null ? oid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opleiding)) {
            return false;
        }
        Opleiding other = (Opleiding) object;
        if ((this.oid == null && other.oid != null) || (this.oid != null && !this.oid.equals(other.oid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sessionBeanPackage.Opleiding[ oid=" + oid + " ]";
    }
    
}
