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
@Table(name = "aditivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aditivos.findAll", query = "SELECT a FROM Aditivos a")
    , @NamedQuery(name = "Aditivos.findByNumerocontratos", query = "SELECT a FROM Aditivos a WHERE a.aditivosPK.numerocontratos = :numerocontratos")
    , @NamedQuery(name = "Aditivos.findByNumeroaditivo", query = "SELECT a FROM Aditivos a WHERE a.aditivosPK.numeroaditivo = :numeroaditivo")
    , @NamedQuery(name = "Aditivos.findByDataassinatura", query = "SELECT a FROM Aditivos a WHERE a.dataassinatura = :dataassinatura")
    , @NamedQuery(name = "Aditivos.findByDatapublicacao", query = "SELECT a FROM Aditivos a WHERE a.datapublicacao = :datapublicacao")})
public class Aditivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AditivosPK aditivosPK;
    @Lob
    @Column(name = "processo")
    private String processo;
    @Lob
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "dataassinatura")
    private String dataassinatura;
    @Column(name = "datapublicacao")
    private String datapublicacao;

    public Aditivos() {
    }

    public Aditivos(AditivosPK aditivosPK, String processo, String descricao, String dataassinatura, String datapublicacao) {
        this.aditivosPK = aditivosPK;
        this.processo = processo;
        this.descricao = descricao;
        this.dataassinatura = dataassinatura;
        this.datapublicacao = datapublicacao;
    }
    

    public Aditivos(AditivosPK aditivosPK) {
        this.aditivosPK = aditivosPK;
    }

    public Aditivos(String numerocontratos, String numeroaditivo) {
        this.aditivosPK = new AditivosPK(numerocontratos, numeroaditivo);
    }

    public AditivosPK getAditivosPK() {
        return aditivosPK;
    }

    public void setAditivosPK(AditivosPK aditivosPK) {
        this.aditivosPK = aditivosPK;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataassinatura() {
        return dataassinatura;
    }

    public void setDataassinatura(String dataassinatura) {
        this.dataassinatura = dataassinatura;
    }

    public String getDatapublicacao() {
        return datapublicacao;
    }

    public void setDatapublicacao(String datapublicacao) {
        this.datapublicacao = datapublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aditivosPK != null ? aditivosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aditivos)) {
            return false;
        }
        Aditivos other = (Aditivos) object;
        if ((this.aditivosPK == null && other.aditivosPK != null) || (this.aditivosPK != null && !this.aditivosPK.equals(other.aditivosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Aditivos[ aditivosPK=" + aditivosPK + " ]";
    }
    
}
