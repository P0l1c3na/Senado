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
import model.Despesa;
/**
 *
 * @author muril
 */
@XmlRootElement(name = "despesas") //RootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Despesas {
    
    @XmlElement(name = "despesa")
    private List<Despesa> despesas = null;

    public List<Despesa> getDespesas() {
        return despesas;
    }

    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
    
    
}
