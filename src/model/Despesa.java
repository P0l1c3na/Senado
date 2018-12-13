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
@Table(name = "despesa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Despesa.findAll", query = "SELECT d FROM Despesa d")
    , @NamedQuery(name = "Despesa.findById", query = "SELECT d FROM Despesa d WHERE d.id = :id")
    , @NamedQuery(name = "Despesa.findByAno", query = "SELECT d FROM Despesa d WHERE d.ano = :ano")
    , @NamedQuery(name = "Despesa.findByMes", query = "SELECT d FROM Despesa d WHERE d.mes = :mes")
    , @NamedQuery(name = "Despesa.findBySenador", query = "SELECT d FROM Despesa d WHERE d.senador = :senador")
    , @NamedQuery(name = "Despesa.findByTipoDespesa", query = "SELECT d FROM Despesa d WHERE d.tipoDespesa = :tipoDespesa")
    , @NamedQuery(name = "Despesa.findByCnpjCpf", query = "SELECT d FROM Despesa d WHERE d.cnpjCpf = :cnpjCpf")
    , @NamedQuery(name = "Despesa.findByFornecedor", query = "SELECT d FROM Despesa d WHERE d.fornecedor = :fornecedor")
    , @NamedQuery(name = "Despesa.findByDocumento", query = "SELECT d FROM Despesa d WHERE d.documento = :documento")
    , @NamedQuery(name = "Despesa.findByData", query = "SELECT d FROM Despesa d WHERE d.data = :data")
    , @NamedQuery(name = "Despesa.findByDetalhamento", query = "SELECT d FROM Despesa d WHERE d.detalhamento = :detalhamento")
    , @NamedQuery(name = "Despesa.findByValorReembolsadoTotal", query = "SELECT SUM(d.valorReembolsado) FROM Despesa d WHERE d.senador = :senador")
    , @NamedQuery(name = "Despesa.findByValorReembolsado", query = "SELECT d FROM Despesa d WHERE d.valorReembolsado = :valorReembolsado")})
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ano")
    private Integer ano;
    @Column(name = "mes")
    private Short mes;
    @Column(name = "senador")
    private String senador;
    @Column(name = "tipo_despesa")
    private String tipoDespesa;
    @Column(name = "cnpj_cpf")
    private String cnpjCpf;
    @Column(name = "fornecedor")
    private String fornecedor;
    @Column(name = "documento")
    private String documento;
    @Column(name = "data_")
    private String data;
    @Column(name = "detalhamento")
    private String detalhamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_reembolsado")
    private Double valorReembolsado;

    public Despesa() {
    }

    public Despesa(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Short getMes() {
        return mes;
    }

    public void setMes(Short mes) {
        this.mes = mes;
    }

    public String getSenador() {
        return senador;
    }

    public void setSenador(String senador) {
        this.senador = senador;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Double getValorReembolsado() {
        return valorReembolsado;
    }

    public void setValorReembolsado(Double valorReembolsado) {
        this.valorReembolsado = valorReembolsado;
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
        if (!(object instanceof Despesa)) {
            return false;
        }
        Despesa other = (Despesa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "control.db.Despesa[ id=" + id + " ]";
    }
    
}
