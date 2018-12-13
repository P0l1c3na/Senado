/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.service.ContratosService;
import control.service.DespesaService;

/**
 *
 * @author muril
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        DespesaService desp = new DespesaService();
//        System.out.println(desp.getXmlStringSugar());
        ContratosService cont = new ContratosService();
        System.out.println(cont.getXmlString());
    }
    
}
