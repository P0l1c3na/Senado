/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.service;

import control.jpa.DespesaJpaController;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.Despesa;

/**
 *
 * @author muril
 */
public class DespesaService {

    public String getXmlString() {

        StringWriter stringWriter = new StringWriter();

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            DespesaJpaController despesaJpa = new DespesaJpaController(emf);

            List<model.Despesa> lista = despesaJpa.findDespesaEntities();

            Despesas despesas = new Despesas();
            despesas.setDespesas(lista);

            JAXBContext context = JAXBContext.newInstance(Despesas.class);
            Marshaller marshall = context.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshall.marshal(despesas, stringWriter/*new FileWriter("despesas.xml")*/);

        } catch (JAXBException ex) {
            Logger.getLogger(Despesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringWriter.toString();
    }

    public String getXmlStringSugar() {

        String aux = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
        DespesaJpaController despesaJpa = new DespesaJpaController(emf);
        List<model.Despesa> lista = despesaJpa.findDespesaEntities();
        HashMap<String, Double> hash = new HashMap();
        for (int i = 0; i < lista.size(); i++) {
            String nome = lista.get(i).getSenador();
            Double valor = lista.get(i).getValorReembolsado();
            if (hash.containsKey(nome)) {
                valor += hash.get(nome);
                hash.put(nome, valor);
            } else {
                hash.put(nome, valor);
            }

        }
        aux = hash.toString();
        return aux;
    }

    public void getXmlList() {
        List<model.Despesa> lista = null;

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            DespesaJpaController despesaJpa = new DespesaJpaController(emf);

            lista = despesaJpa.findDespesaEntities();

            Despesas despesas = new Despesas();
            despesas.setDespesas(lista);

            JAXBContext context = JAXBContext.newInstance(Despesas.class);
            Marshaller marshall = context.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshall.marshal(despesas, new FileWriter("despesas.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(Despesa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DespesaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
