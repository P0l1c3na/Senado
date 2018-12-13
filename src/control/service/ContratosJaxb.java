
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.service;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import model.Contratos;
/**
 *
 * @author muril
 */
@XmlRootElement(name = "despesas") //RootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class ContratosJaxb {
    
    @XmlElement(name = "contratos")
    private List<Contratos> contratos = null;

    public List<Contratos> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contratos> contratos) {
        this.contratos = contratos;
    }

    @Override
    public String toString() {
        return "ContratosJaxb{" + "contratos=" + contratos + '}';
    }
    
    
}
