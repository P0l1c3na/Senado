/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author muril
 */
@Entity
@Table(name = "aposentadoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aposentadoria.findAll", query = "SELECT a FROM Aposentadoria a")
    , @NamedQuery(name = "Aposentadoria.findById", query = "SELECT a FROM Aposentadoria a WHERE a.id = :id")
    , @NamedQuery(name = "Aposentadoria.findByNome", query = "SELECT a FROM Aposentadoria a WHERE a.nome = :nome")
    , @NamedQuery(name = "Aposentadoria.findByTipo", query = "SELECT a FROM Aposentadoria a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Aposentadoria.findByDataIni", query = "SELECT a FROM Aposentadoria a WHERE a.dataIni = :dataIni")
    , @NamedQuery(name = "Aposentadoria.findByDataFim", query = "SELECT a FROM Aposentadoria a WHERE a.dataFim = :dataFim")})
public class Aposentadoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "data_ini")
    private String dataIni;
    @Column(name = "data_fim")
    private String dataFim;

    public Aposentadoria() {
    }

    public Aposentadoria(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aposentadoria)) {
            return false;
        }
        Aposentadoria other = (Aposentadoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Aposentadoria[ id=" + id + " ]";
    }
    
}
