/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author muril
 */
@Entity
@Table(name = "itens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itens.findAll", query = "SELECT i FROM Itens i")
    , @NamedQuery(name = "Itens.findByNumerocontrato", query = "SELECT i FROM Itens i WHERE i.itensPK.numerocontrato = :numerocontrato")
    , @NamedQuery(name = "Itens.findByNumeroitem", query = "SELECT i FROM Itens i WHERE i.itensPK.numeroitem = :numeroitem")
    , @NamedQuery(name = "Itens.findByQuantidadecontratada", query = "SELECT i FROM Itens i WHERE i.quantidadecontratada = :quantidadecontratada")})
public class Itens implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItensPK itensPK;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidadecontratada")
    private String quantidadecontratada;

    public Itens() {
    }

    public Itens(ItensPK itensPK, String descricao, String quantidadecontratada) {
        this.itensPK = itensPK;
        this.descricao = descricao;
        this.quantidadecontratada = quantidadecontratada;
    }
    
    

    public Itens(ItensPK itensPK) {
        this.itensPK = itensPK;
    }

    public Itens(String numerocontrato, String numeroitem) {
        this.itensPK = new ItensPK(numerocontrato, numeroitem);
    }

    public ItensPK getItensPK() {
        return itensPK;
    }

    public void setItensPK(ItensPK itensPK) {
        this.itensPK = itensPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidadecontratada() {
        return quantidadecontratada;
    }

    public void setQuantidadecontratada(String quantidadecontratada) {
        this.quantidadecontratada = quantidadecontratada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itensPK != null ? itensPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itens)) {
            return false;
        }
        Itens other = (Itens) object;
        if ((this.itensPK == null && other.itensPK != null) || (this.itensPK != null && !this.itensPK.equals(other.itensPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Itens[ itensPK=" + itensPK + " ]";
    }
    
}
