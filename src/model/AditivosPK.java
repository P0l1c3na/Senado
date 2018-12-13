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
public class AditivosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "numerocontratos")
    private String numerocontratos;
    @Basic(optional = false)
    @Column(name = "numeroaditivo")
    private String numeroaditivo;

    public AditivosPK() {
    }

    public AditivosPK(String numerocontratos, String numeroaditivo) {
        this.numerocontratos = numerocontratos;
        this.numeroaditivo = numeroaditivo;
    }

    public String getNumerocontratos() {
        return numerocontratos;
    }

    public void setNumerocontratos(String numerocontratos) {
        this.numerocontratos = numerocontratos;
    }

    public String getNumeroaditivo() {
        return numeroaditivo;
    }

    public void setNumeroaditivo(String numeroaditivo) {
        this.numeroaditivo = numeroaditivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocontratos != null ? numerocontratos.hashCode() : 0);
        hash += (numeroaditivo != null ? numeroaditivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AditivosPK)) {
            return false;
        }
        AditivosPK other = (AditivosPK) object;
        if ((this.numerocontratos == null && other.numerocontratos != null) || (this.numerocontratos != null && !this.numerocontratos.equals(other.numerocontratos))) {
            return false;
        }
        if ((this.numeroaditivo == null && other.numeroaditivo != null) || (this.numeroaditivo != null && !this.numeroaditivo.equals(other.numeroaditivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.AditivosPK[ numerocontratos=" + numerocontratos + ", numeroaditivo=" + numeroaditivo + " ]";
    }
    
}
