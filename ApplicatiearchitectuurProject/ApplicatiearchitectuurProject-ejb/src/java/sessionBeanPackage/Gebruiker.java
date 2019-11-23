/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeanPackage;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "gebruiker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gebruiker.findAll", query = "SELECT g FROM Gebruiker g"),
    @NamedQuery(name = "Gebruiker.findByGid", query = "SELECT g FROM Gebruiker g WHERE g.gid = :gid"),
    @NamedQuery(name = "Gebruiker.findByWachtwoord", query = "SELECT g FROM Gebruiker g WHERE g.wachtwoord = :wachtwoord"),
    @NamedQuery(name = "Gebruiker.findByGnaam", query = "SELECT g FROM Gebruiker g WHERE g.gnaam = :gnaam"),
    @NamedQuery(name = "Gebruiker.findByGroep", query = "SELECT g FROM Gebruiker g WHERE g.groep = :groep")})
public class Gebruiker implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "gid")
    private Integer gid;
    @Size(max = 30)
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @Size(max = 20)
    @Column(name = "gnaam")
    private String gnaam;
    @Size(max = 20)
    @Column(name = "groep")
    private String groep;
    @JoinTable(name = "docent", joinColumns = {
        @JoinColumn(name = "gid", referencedColumnName = "gid"),
        @JoinColumn(name = "gid", referencedColumnName = "gid")}, inverseJoinColumns = {
        @JoinColumn(name = "oid", referencedColumnName = "oid"),
        @JoinColumn(name = "oid", referencedColumnName = "oid")})
    @ManyToMany
    private Collection<Opleiding> opleidingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebruiker")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebruiker")
    private Collection<Extern> externCollection;

    public Gebruiker() {
    }

    public Gebruiker(Integer gid) {
        this.gid = gid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getGnaam() {
        return gnaam;
    }

    public void setGnaam(String gnaam) {
        this.gnaam = gnaam;
    }

    public String getGroep() {
        return groep;
    }

    public void setGroep(String groep) {
        this.groep = groep;
    }

    @XmlTransient
    public Collection<Opleiding> getOpleidingCollection() {
        return opleidingCollection;
    }

    public void setOpleidingCollection(Collection<Opleiding> opleidingCollection) {
        this.opleidingCollection = opleidingCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Extern> getExternCollection() {
        return externCollection;
    }

    public void setExternCollection(Collection<Extern> externCollection) {
        this.externCollection = externCollection;
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
        if (!(object instanceof Gebruiker)) {
            return false;
        }
        Gebruiker other = (Gebruiker) object;
        if ((this.gid == null && other.gid != null) || (this.gid != null && !this.gid.equals(other.gid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sessionBeanPackage.Gebruiker[ gid=" + gid + " ]";
    }
    
}
