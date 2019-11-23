/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "extern")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Extern.findAll", query = "SELECT e FROM Extern e"),
    @NamedQuery(name = "Extern.findByGid", query = "SELECT e FROM Extern e WHERE e.gid = :gid")})
public class Extern implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gid")
    private Integer gid;
    @JoinColumns({
        @JoinColumn(name = "gid", referencedColumnName = "gid", insertable = false, updatable = false),
        @JoinColumn(name = "gid", referencedColumnName = "gid", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Gebruiker gebruiker;

    public Extern() {
    }

    public Extern(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gid != null ? gid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extern)) {
            return false;
        }
        Extern other = (Extern) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sessionBeanPackage.Extern[ gid=" + gid + " ]";
    }
    
}
