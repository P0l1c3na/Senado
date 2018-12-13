/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.secutity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.bouncycastle.util.encoders.Base64;

/**
 *
 * @author Raphael Policena
 */
public class Token {

    // EXPIRATION_TIME = 5 minutos
    static final long EXPIRATION_TIME = 300000;
    static final String emissor = "Informa Senado";
    public static final String TOKEN_HEADER = "Authentication";
    String secretkey = UUID.randomUUID().toString().substring(0, 16);
    //SecretKeySpec secretkey = new SecretKeySpec(a.getBytes(), "AES");

    public String createToken(String user) {
//The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("myKey");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId("1")
                .setIssuedAt(now)
                .setSubject(user)
                .setIssuer(emissor)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (EXPIRATION_TIME >= 0) {
            long expMillis = nowMillis + EXPIRATION_TIME;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims validateToken(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("myKey"))
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());

        /// se for o cara mesmo permitir a alteraçaõ de senha, se não negar
        return claims;
    }

    private static class salt {

        public static byte[] saltKey() {
            String a = UUID.randomUUID().toString().substring(0, 16);

            SecretKeySpec key = new SecretKeySpec(a.getBytes(), "AES");
            byte[] codigo = null;

            try {

                Cipher cipher = Cipher.getInstance("AES");

                cipher.init(Cipher.ENCRYPT_MODE, key);
                /* Solicita ao usu?io que informe sua mensagem a ser encriptada */
                String mensagem = "mykey";
                /* Encripta a Mensagem */
                byte[] mensagemEncriptada = cipher.doFinal(mensagem.getBytes());
                /*Converte para a base 64 e amazena a mensagem em uma variavel*/
                codigo = Base64.encode(mensagemEncriptada);

                System.out.println("Mensagem Encriptada: " + codigo + "\n" + "key: " + a);

            } catch (Exception e) {

            }
            return codigo;
        }
    }

}
