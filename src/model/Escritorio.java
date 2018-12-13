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
@Table(name = "escritorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escritorio.findAll", query = "SELECT e FROM Escritorio e")
    , @NamedQuery(name = "Escritorio.findById", query = "SELECT e FROM Escritorio e WHERE e.id = :id")
    , @NamedQuery(name = "Escritorio.findByNome", query = "SELECT e FROM Escritorio e WHERE e.nome = :nome")
    , @NamedQuery(name = "Escritorio.findByEstado", query = "SELECT e FROM Escritorio e WHERE e.estado = :estado")
    , @NamedQuery(name = "Escritorio.findBySetor", query = "SELECT e FROM Escritorio e WHERE e.setor = :setor")
    , @NamedQuery(name = "Escritorio.findByEndereco", query = "SELECT e FROM Escritorio e WHERE e.endereco = :endereco")
    , @NamedQuery(name = "Escritorio.findByTelefone", query = "SELECT e FROM Escritorio e WHERE e.telefone = :telefone")
    , @NamedQuery(name = "Escritorio.findByFax", query = "SELECT e FROM Escritorio e WHERE e.fax = :fax")})
public class Escritorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "estado")
    private String estado;
    @Column(name = "setor")
    private String setor;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "fax")
    private String fax;

    public Escritorio() {
    }

    public Escritorio(Integer id) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        if (!(object instanceof Escritorio)) {
            return false;
        }
        Escritorio other = (Escritorio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Escritorio[ id=" + id + " ]";
    }
    
}
