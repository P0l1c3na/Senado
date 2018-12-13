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
@Table(name = "imovel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imovel.findAll", query = "SELECT i FROM Imovel i")
    , @NamedQuery(name = "Imovel.findById", query = "SELECT i FROM Imovel i WHERE i.id = :id")
    , @NamedQuery(name = "Imovel.findByNome", query = "SELECT i FROM Imovel i WHERE i.nome = :nome")
    , @NamedQuery(name = "Imovel.findByAuxilioMoradia", query = "SELECT i FROM Imovel i WHERE i.auxilioMoradia = :auxilioMoradia")
    , @NamedQuery(name = "Imovel.findByImovelFuncional", query = "SELECT i FROM Imovel i WHERE i.imovelFuncional = :imovelFuncional")})
public class Imovel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "auxilio_moradia")
    private String auxilioMoradia;
    @Column(name = "imovel_funcional")
    private String imovelFuncional;

    public Imovel() {
    }

    public Imovel(Integer id) {
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

    public String getAuxilioMoradia() {
        return auxilioMoradia;
    }

    public void setAuxilioMoradia(String auxilioMoradia) {
        this.auxilioMoradia = auxilioMoradia;
    }

    public String getImovelFuncional() {
        return imovelFuncional;
    }

    public void setImovelFuncional(String imovelFuncional) {
        this.imovelFuncional = imovelFuncional;
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
        if (!(object instanceof Imovel)) {
            return false;
        }
        Imovel other = (Imovel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Imovel[ id=" + id + " ]";
    }
    
}
