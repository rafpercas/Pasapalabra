package edu.proyectodual.pasapalabra.email;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Sender {

    Properties mailProp = new Properties();

    Properties credentialProp = new Properties();

    public Properties getMailProp() {
        return mailProp;
    }

    public void setMailProp(Properties mailProp) {
        this.mailProp = mailProp;
    }

    public Properties getCredentialProp() {
        return credentialProp;
    }

    public void setCredentialProp(Properties credentialProp) {
        this.credentialProp = credentialProp;
    }

    public Sender() {
        try {
            // Loads all the properties of file "mail.properties".
            mailProp.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
            credentialProp.load(getClass().getClassLoader().getResourceAsStream("credential.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean send(String from, String to, String subject, String content) {
        // Get the Session object.// and pass username and password
        Session session = createSession();
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject(subject);
            // Now set the actual message
            message.setContent(content, "text/html");
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }

    }

    private Session createSession() {
        Session session = Session.getInstance(mailProp, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(credentialProp.getProperty(CredentialsConstants.USER),
                        credentialProp.getProperty(CredentialsConstants.PASSWD));
            }
        });
        // Used to debug SMTP issues
        session.setDebug(true);
        return session;
    }

    public static void main(String[] args) {
        new Sender().send("proyectodualpasapalabra@gmail.com", "perezcastanor@gmail.com", "Hola =D",
                "<b>Asi se envian correos con Java...<b>");
    }


}

