/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author muril
 */
@Embeddable
public class ItensPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numerocontrato")
    private String numerocontrato;
    @Basic(optional = false)
    @Column(name = "numeroitem")
    private String numeroitem;

    public ItensPK() {
    }

    public ItensPK(String numerocontrato, String numeroitem) {
        this.numerocontrato = numerocontrato;
        this.numeroitem = numeroitem;
    }

    public String getNumerocontrato() {
        return numerocontrato;
    }

    public void setNumerocontrato(String numerocontrato) {
        this.numerocontrato = numerocontrato;
    }

    public String getNumeroitem() {
        return numeroitem;
    }

    public void setNumeroitem(String numeroitem) {
        this.numeroitem = numeroitem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocontrato != null ? numerocontrato.hashCode() : 0);
        hash += (numeroitem != null ? numeroitem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPK)) {
            return false;
        }
        ItensPK other = (ItensPK) object;
        if ((this.numerocontrato == null && other.numerocontrato != null) || (this.numerocontrato != null && !this.numerocontrato.equals(other.numerocontrato))) {
            return false;
        }
        if ((this.numeroitem == null && other.numeroitem != null) || (this.numeroitem != null && !this.numeroitem.equals(other.numeroitem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.ItensPK[ numerocontrato=" + numerocontrato + ", numeroitem=" + numeroitem + " ]";
    }
    
}
