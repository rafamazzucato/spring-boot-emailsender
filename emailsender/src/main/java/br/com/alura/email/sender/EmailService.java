package br.com.alura.email.sender;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

/**
 * Created by rafaelthomazelli on 31/03/17.
 */
@Service
public class EmailService {


    public void send(String name, String emailTo){
        try {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("testeemailspringboot@gmail.com", "springboottest"));
            email.setSSLOnConnect(true);

            email.setFrom("testeemailspringboot@gmail.com");
            email.setSubject("Você foi convidado pelo ListaVIP");
            email.setMsg("Olá " + name + ". Você acaba de ser convidado pelo ListaVIP.");
            email.addTo(emailTo);
            email.send();

        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
