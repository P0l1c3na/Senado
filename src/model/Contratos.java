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
@Table(name = "contratos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contratos.findAll", query = "SELECT c FROM Contratos c")
    , @NamedQuery(name = "Contratos.findByNumerocontratos", query = "SELECT c FROM Contratos c WHERE c.numerocontratos = :numerocontratos")
    , @NamedQuery(name = "Contratos.findByUnidadegestoria", query = "SELECT c FROM Contratos c WHERE c.unidadegestoria = :unidadegestoria")
    , @NamedQuery(name = "Contratos.findByContratada", query = "SELECT c FROM Contratos c WHERE c.contratada = :contratada")
    , @NamedQuery(name = "Contratos.findByCnpj", query = "SELECT c FROM Contratos c WHERE c.cnpj = :cnpj")
    , @NamedQuery(name = "Contratos.findByObjeto", query = "SELECT c FROM Contratos c WHERE c.objeto = :objeto")
    , @NamedQuery(name = "Contratos.findByDataassinatura", query = "SELECT c FROM Contratos c WHERE c.dataassinatura = :dataassinatura")
    , @NamedQuery(name = "Contratos.findByDatapublicacao", query = "SELECT c FROM Contratos c WHERE c.datapublicacao = :datapublicacao")
    , @NamedQuery(name = "Contratos.findByIniciovigencia", query = "SELECT c FROM Contratos c WHERE c.iniciovigencia = :iniciovigencia")
    , @NamedQuery(name = "Contratos.findByFimvigencia", query = "SELECT c FROM Contratos c WHERE c.fimvigencia = :fimvigencia")
    , @NamedQuery(name = "Contratos.findByModalidade", query = "SELECT c FROM Contratos c WHERE c.modalidade = :modalidade")
    , @NamedQuery(name = "Contratos.findByNumerolicitacao", query = "SELECT c FROM Contratos c WHERE c.numerolicitacao = :numerolicitacao")
    , @NamedQuery(name = "Contratos.findByProcesso", query = "SELECT c FROM Contratos c WHERE c.processo = :processo")})
public class Contratos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numerocontratos")
    private String numerocontratos;
    @Column(name = "unidadegestoria")
    private String unidadegestoria;
    @Column(name = "contratada")
    private String contratada;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "objeto")
    private String objeto;
    @Column(name = "dataassinatura")
    private String dataassinatura;
    @Column(name = "datapublicacao")
    private String datapublicacao;
    @Column(name = "iniciovigencia")
    private String iniciovigencia;
    @Column(name = "fimvigencia")
    private String fimvigencia;
    @Column(name = "modalidade")
    private String modalidade;
    @Column(name = "numerolicitacao")
    private String numerolicitacao;
    @Column(name = "processo")
    private String processo;

    public Contratos() {
    }

    public Contratos(String numerocontratos, String unidadegestoria, String contratada, String cnpj, String objeto, String dataassinatura, String datapublicacao, String iniciovigencia, String fimvigencia, String modalidade, String numerolicitacao, String processo) {
        this.numerocontratos = numerocontratos;
        this.unidadegestoria = unidadegestoria;
        this.contratada = contratada;
        this.cnpj = cnpj;
        this.objeto = objeto;
        this.dataassinatura = dataassinatura;
        this.datapublicacao = datapublicacao;
        this.iniciovigencia = iniciovigencia;
        this.fimvigencia = fimvigencia;
        this.modalidade = modalidade;
        this.numerolicitacao = numerolicitacao;
        this.processo = processo;
    }
    
    

    public Contratos(String numerocontratos) {
        this.numerocontratos = numerocontratos;
    }

    public String getNumerocontratos() {
        return numerocontratos;
    }

    public void setNumerocontratos(String numerocontratos) {
        this.numerocontratos = numerocontratos;
    }

    public String getUnidadegestoria() {
        return unidadegestoria;
    }

    public void setUnidadegestoria(String unidadegestoria) {
        this.unidadegestoria = unidadegestoria;
    }

    public String getContratada() {
        return contratada;
    }

    public void setContratada(String contratada) {
        this.contratada = contratada;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
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

    public String getIniciovigencia() {
        return iniciovigencia;
    }

    public void setIniciovigencia(String iniciovigencia) {
        this.iniciovigencia = iniciovigencia;
    }

    public String getFimvigencia() {
        return fimvigencia;
    }

    public void setFimvigencia(String fimvigencia) {
        this.fimvigencia = fimvigencia;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getNumerolicitacao() {
        return numerolicitacao;
    }

    public void setNumerolicitacao(String numerolicitacao) {
        this.numerolicitacao = numerolicitacao;
    }

    public String getProcesso() {
        return processo;
    }

    public void setProcesso(String processo) {
        this.processo = processo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocontratos != null ? numerocontratos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contratos)) {
            return false;
        }
        Contratos other = (Contratos) object;
        if ((this.numerocontratos == null && other.numerocontratos != null) || (this.numerocontratos != null && !this.numerocontratos.equals(other.numerocontratos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Contratos[ numerocontratos=" + numerocontratos + " ]";
    }
    
}
