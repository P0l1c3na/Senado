/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.clienteREST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import jaxb.ListaParlamentarEmExercicio;
import jaxb.Parlamentar;

/**
 *
 * @author muril
 */
public class Senadores {

    int HTTP_COD_SUCESSO = 200;
    List<Parlamentar> lista;

    public List<Parlamentar> callSenadores() {
        try {
            URL url = new URL("http://legis.senado.leg.br/dadosabertos/senador/lista/atual");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() != HTTP_COD_SUCESSO) {
                throw new RuntimeException("HTTP erro code: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            JAXBContext jaxbcontext = JAXBContext.newInstance(jaxb.ListaParlamentarEmExercicio.class);
            Unmarshaller jaxbUn = jaxbcontext.createUnmarshaller();

            ListaParlamentarEmExercicio listaParlamentares = (ListaParlamentarEmExercicio) jaxbUn.unmarshal(br);
            lista = listaParlamentares.getParlamentares().getParlamentar();

        } catch (MalformedURLException ex) {
            Logger.getLogger(Senadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Senadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Senadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Parlamentar callSenadoresID(int id) {
        Parlamentar parlamentar = new Parlamentar();
        try {
            URL url = new URL("http://legis.senado.leg.br/dadosabertos/senador/lista/atual");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            if (con.getResponseCode() != HTTP_COD_SUCESSO) {
                throw new RuntimeException("HTTP erro code: " + con.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

            JAXBContext jaxbcontext = JAXBContext.newInstance(jaxb.ListaParlamentarEmExercicio.class);
            Unmarshaller jaxbUn = jaxbcontext.createUnmarshaller();

            ListaParlamentarEmExercicio listaParlamentar = (ListaParlamentarEmExercicio) jaxbUn.unmarshal(br);
            lista = listaParlamentar.getParlamentares().getParlamentar();
            for (int i = 0; i < lista.size(); i++) {
                //Problema
                if (lista.get(i).getIdentificacaoParlamentar().getCodigoParlamentar() == (id)) {
                    parlamentar = lista.get(i);
                    System.out.println(lista.get(i));
                    break;
                }
            }
            return parlamentar;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Senadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Senadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Senadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parlamentar;
    }
}