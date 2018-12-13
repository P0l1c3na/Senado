/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.secutity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raphael Policena
 */
public class SecurityCrypto {

    public static String encrypt(String password) {
        MessageDigest algorithm = null;
        byte messageDigest[] = null;
        StringBuilder hexString = null;
        String senha = null;
        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            messageDigest = algorithm.digest(password.getBytes("UTF-8"));

            hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02X", 0xFF & b));
            }
            senha = hexString.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityCrypto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SecurityCrypto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return senha;
    }
}
