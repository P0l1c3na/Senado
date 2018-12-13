/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.csvReader;

import model.Aditivos;
import model.AditivosPK;
import model.Aposentadoria;
import model.Contratos;
import model.Despesa;
import model.Escritorio;
import model.Imovel;
import model.Itens;
import model.ItensPK;
import control.jpa.AditivosJpaController;
import control.jpa.AposentadoriaJpaController;
import control.jpa.ContratosJpaController;
import control.jpa.DespesaJpaController;
import control.jpa.EscritorioJpaController;
import control.jpa.ImovelJpaController;
import control.jpa.ItensJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author muril
 */
public class ReadCSV {

    public void deleteFrom(String tabela) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("DELETE FROM " + tabela);
            q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro delete " + tabela + ": " + e);
        } finally {
            em.close();
        }
    }

    public void readAposentadoria() {
        //IPC Aposentados senadores
        String aposentadosCSV = ".\\csv\\ipc_aposentados_senadores_csv.csv";
        String line = "";
        int id = 1;

        BufferedReader bfAposentadosCSV;
        try {
            bfAposentadosCSV = new BufferedReader(new InputStreamReader(new FileInputStream(aposentadosCSV), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            AposentadoriaJpaController jpaAposentadoria = new AposentadoriaJpaController(emf);
            jpaAposentadoria.getEntityManager();

            deleteFrom("aposentadoria");

            try {
                int contaLinha = 0;
                while ((line = bfAposentadosCSV.readLine()) != null) {
                    if (contaLinha > 1) {
                        //le a linha do csv e a coloca num vetor de String
                        String[] data = line.split(";");
                        Aposentadoria aposentado = new Aposentadoria();
                        aposentado.setId(id);
                        aposentado.setNome(data[0]);
                        aposentado.setTipo(data[1]);
                        aposentado.setDataIni(data[2]);
                        aposentado.setDataFim(data[3]);
                        jpaAposentadoria.create(aposentado);
                        id++;
                    }
                    contaLinha++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("APOSENTADORIA Erro, arquivo não encontrado: " + e);
            } catch (IndexOutOfBoundsException d) {
                System.out.println("APOSENTADORIA Erro de indexador" + d);
            } catch (IOException i) {
                System.out.println("APOSENTADORIA IOException: " + i);
            } catch (Exception ex) {
                System.out.println("APOSENTADORIA: " + ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("APOSENTADORIA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("APOSENTADORIA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        //IPC Pensionistas senadores
        String pensionistasCSV = ".\\csv\\ipc_pensionistas_senadores_csv.csv";
        line = "";

        BufferedReader bfPensionistasCSV;
        try {
            bfPensionistasCSV = new BufferedReader(new InputStreamReader(new FileInputStream(pensionistasCSV), "UTF-8"));

            EntityManagerFactory emfPensionista = Persistence.createEntityManagerFactory("SenadoPU");
            AposentadoriaJpaController jpaPensionista = new AposentadoriaJpaController(emfPensionista);
            jpaPensionista.getEntityManager();

            try {
                int contaLinha = 0;
                while ((line = bfPensionistasCSV.readLine()) != null) {
                    if (contaLinha > 1) {
                        //le a linha do csv e a coloca num vetor de String
                        String[] data = line.split(";");
                        Aposentadoria aposentado = new Aposentadoria();
                        aposentado.setId(id);
                        aposentado.setNome(data[0]);
                        aposentado.setTipo(data[1]);
                        aposentado.setDataIni(data[2]);
                        aposentado.setDataFim(data[3]);
                        jpaPensionista.create(aposentado);
                        id++;
                    }
                    contaLinha++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("APOSENTADORIA Erro, arquivo não encontrado: " + e);
            } catch (IndexOutOfBoundsException d) {
                System.out.println("APOSENTADORIA Erro de indexador" + d);
            } catch (IOException i) {
                System.out.println("APOSENTADORIA IOException: " + i);
            } catch (Exception ex) {
                System.out.println("APOSENTADORIA: " + ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("APOSENTADORIA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("APOSENTADORIA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        //PSSC Aposentados senadores
        String psscAposentadosSenadores = ".\\csv\\pssc_aposentados_senadores_csv.csv";
        line = "";

        BufferedReader bfPsscAposentadosCSV;
        try {
            bfPsscAposentadosCSV = new BufferedReader(new InputStreamReader(new FileInputStream(psscAposentadosSenadores), "UTF-8"));

            EntityManagerFactory emfPsscAposentados = Persistence.createEntityManagerFactory("SenadoPU");
            AposentadoriaJpaController jpaPsscAposentados = new AposentadoriaJpaController(emfPsscAposentados);
            jpaPsscAposentados.getEntityManager();

            try {
                int contaLinha = 0;
                while ((line = bfPsscAposentadosCSV.readLine()) != null) {
                    if (contaLinha > 1) {
                        //le a linha do csv e a coloca num vetor de String
                        String[] data = line.split(";");
                        Aposentadoria aposentado = new Aposentadoria();
                        aposentado.setId(id);
                        aposentado.setNome(data[0]);
                        aposentado.setTipo(data[1]);
                        aposentado.setDataIni(data[2]);
                        aposentado.setDataFim(data[3]);
                        jpaPsscAposentados.create(aposentado);
                        id++;
                    }
                    contaLinha++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("APOSENTADORIA Erro, arquivo não encontrado: " + e);
            } catch (IndexOutOfBoundsException d) {
                System.out.println("APOSENTADORIA Erro de indexador" + d);
            } catch (IOException i) {
                System.out.println("APOSENTADORIA IOException: " + i);
            } catch (Exception ex) {
                System.out.println("APOSENTADORIA Rapaz deu erro: " + ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("APOSENTADORIA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("APOSENTADORIA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readDespesa() {
        String escritoriosCSV = ".\\csv\\escritorios_apoio_csv.csv";
        String data2018 = ".\\csv\\2018.csv";
        String line = "";
        int id = 1;

        BufferedReader bfEscritoriosCSV;
        BufferedReader bfData2018;
        try {
            bfEscritoriosCSV = new BufferedReader(new InputStreamReader(new FileInputStream(escritoriosCSV), "UTF-8"));
            bfData2018 = new BufferedReader(new InputStreamReader(new FileInputStream(data2018), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");

            DespesaJpaController jpaDespesa = new DespesaJpaController(emf);
            jpaDespesa.getEntityManager();

            deleteFrom("despesa");

            try {
                int contaLinha = 0;
                //Leitura do arquivo contratos.csv
                while ((line = bfData2018.readLine()) != null) {
                    if (contaLinha > 1) {
                        //le a linha do csv e a coloca num vetor de String
                        String[] data = line.split("\";\"");

                        for (int i = 0; i < data.length; i++) {
                            data[i] = data[i].replace("\"", "");
                        }

                        Despesa despesa = new Despesa();
                        despesa.setId(id);
                        despesa.setAno(Integer.parseInt(data[0]));
                        if (data[1] != null) {
                            despesa.setMes(Short.parseShort(data[1]));
                        }
                        despesa.setSenador(data[2]);
                        despesa.setTipoDespesa(data[3]);
                        despesa.setCnpjCpf(data[4]);
                        despesa.setFornecedor(data[5]);
                        despesa.setDocumento(data[6]);
                        despesa.setData(data[7]);
                        despesa.setDetalhamento(data[8]);
                        data[9] = data[9].replace(",", ".");
                        despesa.setValorReembolsado(Double.parseDouble(data[9]));
                        jpaDespesa.create(despesa);
                        id++;
                    }
                    contaLinha++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("DESPESA Erro, arquivo não encontrado: " + e);
            } catch (IndexOutOfBoundsException d) {
                System.out.println("DESPESA Erro de indexador" + d);
            } catch (IOException i) {
                System.out.println("DESPESA IOException: " + i);
            } catch (Exception ex) {
                System.out.println("DESPESA: " + ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("DESPESA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("DESPESA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readEscritorio() {
        String escritoriosCSV = ".\\csv\\escritorios_apoio_csv.csv";
        String line = "";
        int id = 1;

        BufferedReader bfEscritoriosCSV;
        try {
            bfEscritoriosCSV = new BufferedReader(new InputStreamReader(new FileInputStream(escritoriosCSV), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");

            EscritorioJpaController jpaEscritorio = new EscritorioJpaController(emf);
            jpaEscritorio.getEntityManager();

            deleteFrom("escritorio");

            try {
                int contaLinha = 0;
                //Leitura do arquivo contratos.csv
                while ((line = bfEscritoriosCSV.readLine()) != null) {
                    if (contaLinha > 1) {
                        //le a linha do csv e a coloca num vetor de String
                        String[] data = line.split(";");

                        for (int i = 0; i < data.length; i++) {
                            data[i] = data[i].replace("\"", "");
                        }

                        Escritorio escritorio = new Escritorio();
                        escritorio.setNome(data[0]);
                        escritorio.setEstado(data[1]);
                        escritorio.setSetor(data[3]);
                        escritorio.setEndereco(data[4]);
                        escritorio.setTelefone(data[5]);
                        escritorio.setFax(data[6]);

                        jpaEscritorio.create(escritorio);

                        id++;
                    }
                    contaLinha++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("ESCRITORIO Erro, arquivo não encontrado: " + e);
            } catch (IndexOutOfBoundsException d) {
                System.out.println("ESCRITORIO Erro de indexador" + d);
            } catch (IOException i) {
                System.out.println("ESCRITORIO IOException: " + i);
            } catch (Exception ex) {
                System.out.println("ESCRITORIO Rapaz deu erro: " + ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("DESPESA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("DESPESA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readImovel() {
        String imovelCSV = ".\\csv\\senador_auxilio_imoveis_csv.csv";
        String line = "";
        int id = 1;

        BufferedReader bfImovelCSV;
        try {
            bfImovelCSV = new BufferedReader(new InputStreamReader(new FileInputStream(imovelCSV), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");

            ImovelJpaController jpaImovel = new ImovelJpaController(emf);
            jpaImovel.getEntityManager();

            deleteFrom("imovel");

            try {
                int contaLinha = 0;
                //Leitura do arquivo contratos.csv
                while ((line = bfImovelCSV.readLine()) != null) {
                    if (contaLinha > 1) {
                        //le a linha do csv e a coloca num vetor de String
                        String[] data = line.split(";");

                        for (int i = 0; i < data.length; i++) {
                            data[i] = data[i].replace("\"", "");
                        }

                        Imovel imovel = new Imovel();

                        imovel.setNome(data[0]);
                        imovel.setAuxilioMoradia(data[3]);
                        imovel.setImovelFuncional(data[4]);

                        jpaImovel.create(imovel);
                        id++;
                    }
                    contaLinha++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("ESCRITORIO Erro, arquivo não encontrado: " + e);
            } catch (IndexOutOfBoundsException d) {
                System.out.println("ESCRITORIO Erro de indexador" + d);
            } catch (IOException i) {
                System.out.println("ESCRITORIO IOException: " + i);
            } catch (Exception ex) {
                System.out.println("DESPESA Rapaz deu erro: " + ex);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("DESPESA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            System.out.println("DESPESA Erro em ReadCSV -> readAposentadoria()\n");
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readItens() {
        String itenscsv = ".\\csv\\itens.csv";

        String line = "";
        String splitter = ";";
        try {
            BufferedReader csvDateItens;

            csvDateItens = new BufferedReader(new InputStreamReader(new FileInputStream(itenscsv), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            ItensJpaController jpaitens = new ItensJpaController(emf);
            jpaitens.getEntityManager();

            //Leitura do arquivo itens.csv
            while ((line = csvDateItens.readLine()) != null) {

                /*le a linha do csv e a coloca num vetor de String*/
                String[] date3 = line.split(splitter);

                ItensPK itempk = new ItensPK(date3[0], date3[1]);
                Itens item = new Itens(itempk, date3[2], date3[3]);

                if (jpaitens.findItens(itempk) == null) {
                    jpaitens.create(item);
                }

                //itensList.add(item);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro, arquivo não encontrado: " + e);
        } catch (IndexOutOfBoundsException d) {
            System.out.println("Erro de indexador" + d);
        } catch (IOException i) {
            System.out.println("Erro de IO(IN OUT) " + i);
        } catch (Exception ex) {
            System.out.println("Erro desconhecido durante a tentativa de ler o arquivo! " + ex);
        }
    }

    public void readAditivos() {
        
        deleteFrom("aditivos");
        
        String aditivoscsv = ".\\csv\\aditivos.csv";
        String line = "";
        String splitter = "\";\"";
        try {
            BufferedReader csvDateAditivos;

            csvDateAditivos = new BufferedReader(new InputStreamReader(new FileInputStream(aditivoscsv), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            AditivosJpaController jpaditvos = new AditivosJpaController(emf);
            jpaditvos.getEntityManager();

            //Leitura do arquivo aditivos.csv
            while ((line = csvDateAditivos.readLine()) != null) {

                /*le a linha do csv e a coloca num vetor de String*/
                String[] date2 = line.split(splitter);

                AditivosPK aditivosPK = new AditivosPK(date2[0], date2[1]);
                Aditivos adetivos = new Aditivos(aditivosPK, date2[2], date2[3], date2[4], date2[5]);

                if (jpaditvos.findAditivos(aditivosPK) == null) {
                    jpaditvos.create(adetivos);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro, arquivo não encontrado: " + e);
        } catch (IndexOutOfBoundsException d) {
            System.out.println("Erro de indexador" + d);
        } catch (IOException i) {
            System.out.println("Erro de IO(IN OUT): " + i);
        } catch (Exception ex) {
            System.out.println("Erro desconhecido durante a tentativa de ler o arquivo! " + ex);
        }
    }

    public void readContratos() {
        String contratoscsv = ".\\csv\\contratos.csv";

        String line = "";
        String splitter = ";";
        try {
            BufferedReader csvDateContratos;
            csvDateContratos = new BufferedReader(new InputStreamReader(new FileInputStream(contratoscsv), "UTF-8"));

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SenadoPU");
            ContratosJpaController jpacontratos = new ContratosJpaController(emf);
            jpacontratos.getEntityManager();

            //Leitura do arquivo contratos.csv
            while ((line = csvDateContratos.readLine()) != null) {

                /*le a linha do csv e a coloca num vetor de String*/
                String[] date = line.split(splitter);

                Contratos contrato = new Contratos(date[0], date[1], date[2],
                        date[3], date[4], date[5], date[6], date[7], date[8], date[9], date[10], date[11]);

                if (jpacontratos.findContratos(date[0]) == null) {
                    jpacontratos.create(contrato);

                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro, arquivo não encontrado: " + e);
        } catch (IndexOutOfBoundsException d) {
            System.out.println("Erro de indexador" + d);
        } catch (IOException i) {
            System.out.println("Erro de IO(IN OUT): " + i);
        } catch (Exception ex) {
            System.out.println("Erro desconhecido durante a tentativa de ler o arquivo! " + ex);
        }

    }
}
