/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.csvReader.ReadCSV;
import control.secutity.JavaMailApp;
import control.secutity.SecurityCrypto;
import control.secutity.Token;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author muril
 */
public class ReadFromCSV {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ReadCSV read = new ReadCSV();

        //read.readAposentadoria();
        //read.readDespesa();
        //read.readEscritorio();
        //read.readImovel();
        //read.readContratos();
        //read.readAditivos();
        //read.readItens();
        Token token = new Token();
                
        String email = "phaelpolicena@gmail.com";
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
                EntityManager em = emf.createEntityManager();
                String password = SecurityCrypto.encrypt("P0l1c3n@19@");
                
                em.getTransaction().begin();
                Query userQuery = em.createNamedQuery("Usuario.updatePassword")
                        .setParameter("bloqueado", false)
                        .setParameter("tentativas", 0)
                        .setParameter("password", password)
                        .setParameter("email", email);
                           userQuery.executeUpdate();
                em.getTransaction().commit();

        /*
        
        String link = token.createToken("joao@gmail.com");
        JavaMailApp.sendEmail(link , "phaelpolicena@gmail.com");
        
        Token.validateToken(link);
         */
 /*
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
        
        UsuarioJpaController cajpa = new UsuarioJpaController (emf);
        cajpa.getEntityManager();
        java.util.Date date = new Date();
        UsuarioPK pk = new UsuarioPK(0, "phaelpolicena@gmail.com");
        Usuario user = new Usuario(pk, "Raphael Policena", sdads, date);        
        cajpa.create(user);
        
         */
    }

}
