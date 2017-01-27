/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author VIGNESH
 */
@Entity
@Table(name = "authority")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authority.findAll", query = "SELECT a FROM Authority a"),
    @NamedQuery(name = "Authority.findByIdAuthority", query = "SELECT a FROM Authority a WHERE a.idAuthority = :idAuthority"),
    @NamedQuery(name = "Authority.findByName", query = "SELECT a FROM Authority a WHERE a.name = :name")})
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_authority")
    private Short idAuthority;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "authority")
    private Collection<UserHasRole> userHasRoleCollection;

    public Authority() {
    }

    public Authority(Short idAuthority) {
        this.idAuthority = idAuthority;
    }

    public Authority(Short idAuthority, String name) {
        this.idAuthority = idAuthority;
        this.name = name;
    }

    public Short getIdAuthority() {
        return idAuthority;
    }

    public void setIdAuthority(Short idAuthority) {
        this.idAuthority = idAuthority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<UserHasRole> getUserHasRoleCollection() {
        return userHasRoleCollection;
    }

    public void setUserHasRoleCollection(Collection<UserHasRole> userHasRoleCollection) {
        this.userHasRoleCollection = userHasRoleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuthority != null ? idAuthority.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authority)) {
            return false;
        }
        Authority other = (Authority) object;
        if ((this.idAuthority == null && other.idAuthority != null) || (this.idAuthority != null && !this.idAuthority.equals(other.idAuthority))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.es.security.persistence.Authority[ idAuthority=" + idAuthority + " ]";
    }
    
}
