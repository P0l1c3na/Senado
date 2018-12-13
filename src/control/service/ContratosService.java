/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.service;

import control.jpa.ContratosJpaController;
import java.io.StringWriter;
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
 * @author Raphael Policena
 */
public class ContratosService {
    

    public String getXmlString() {
        
        StringWriter stringWriter = new StringWriter();
        
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            ContratosJpaController contratosJpa = new ContratosJpaController(emf);

            List<model.Contratos> lista = contratosJpa.findContratosEntities();

            ContratosJaxb contratos = new ContratosJaxb();
            contratos.setContratos(lista);

            JAXBContext context = JAXBContext.newInstance(ContratosJaxb.class);
            Marshaller marshall = context.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshall.marshal(contratos, stringWriter/*new FileWriter("despesas.xml")*/);

        } catch (JAXBException ex) {
            Logger.getLogger(Despesa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stringWriter.toString();
    }
}
    

