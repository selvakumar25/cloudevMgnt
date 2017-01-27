/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.es.security.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author VIGNESH
 */
@Embeddable
public class UserHasRolePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_authority")
    private short idAuthority;

    public UserHasRolePK() {
    }

    public UserHasRolePK(int idUser, short idAuthority) {
        this.idUser = idUser;
        this.idAuthority = idAuthority;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public short getIdAuthority() {
        return idAuthority;
    }

    public void setIdAuthority(short idAuthority) {
        this.idAuthority = idAuthority;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idAuthority;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasRolePK)) {
            return false;
        }
        UserHasRolePK other = (UserHasRolePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idAuthority != other.idAuthority) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.es.security.persistence.UserHasRolePK[ idUser=" + idUser + ", idAuthority=" + idAuthority + " ]";
    }
    
}
