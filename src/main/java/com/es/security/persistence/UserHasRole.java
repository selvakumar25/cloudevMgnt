/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author VIGNESH
 */
@Entity
@Table(name = "user_has_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHasRole.findAll", query = "SELECT u FROM UserHasRole u"),
    @NamedQuery(name = "UserHasRole.findByIdUser", query = "SELECT u FROM UserHasRole u WHERE u.userHasRolePK.idUser = :idUser"),
    @NamedQuery(name = "UserHasRole.findByIdAuthority", query = "SELECT u FROM UserHasRole u WHERE u.userHasRolePK.idAuthority = :idAuthority"),
    @NamedQuery(name = "UserHasRole.findByIdFunction", query = "SELECT u FROM UserHasRole u WHERE u.idFunction = :idFunction")})
public class UserHasRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasRolePK userHasRolePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_function")
    private int idFunction;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "id_authority", referencedColumnName = "id_authority", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Authority authority;

    public UserHasRole() {
    }

    public UserHasRole(UserHasRolePK userHasRolePK) {
        this.userHasRolePK = userHasRolePK;
    }

    public UserHasRole(UserHasRolePK userHasRolePK, int idFunction) {
        this.userHasRolePK = userHasRolePK;
        this.idFunction = idFunction;
    }

    public UserHasRole(int idUser, short idAuthority) {
        this.userHasRolePK = new UserHasRolePK(idUser, idAuthority);
    }

    public UserHasRolePK getUserHasRolePK() {
        return userHasRolePK;
    }

    public void setUserHasRolePK(UserHasRolePK userHasRolePK) {
        this.userHasRolePK = userHasRolePK;
    }

    public int getIdFunction() {
        return idFunction;
    }

    public void setIdFunction(int idFunction) {
        this.idFunction = idFunction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasRolePK != null ? userHasRolePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasRole)) {
            return false;
        }
        UserHasRole other = (UserHasRole) object;
        if ((this.userHasRolePK == null && other.userHasRolePK != null) || (this.userHasRolePK != null && !this.userHasRolePK.equals(other.userHasRolePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.es.security.persistence.UserHasRole[ userHasRolePK=" + userHasRolePK + " ]";
    }
    
}
