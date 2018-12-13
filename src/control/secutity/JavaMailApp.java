/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.secutity;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class JavaMailApp
{
      public void sendEmail(String link, String userEmail) {
            Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.ssl.trust", "*");
 
            Session session = Session.getInstance(props,
                        new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication("informasenadourt@gmail.com", "InformaSenado123");
                             }
                        });
 
            /* Ativa Debug para sessão */
            session.setDebug(true);
 
            try {
 
                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("informasenadourt@gmail.com")); //Remetente
 
                  Address[] toUser = InternetAddress.parse(userEmail); //Destinatário(s) 
 
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Link para a recuperação de Senha");//Assunto
                  message.setText(link);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
 
             } catch (MessagingException e) {
                  System.out.println("Erro ao enviar mensagem! " + e);
            }
            
      }
}
