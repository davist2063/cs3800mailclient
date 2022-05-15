package mailClient;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailUtil {
	private String to; //Recipient email
	private String from; //Sender email
	private String senderPass; //Sender password
	private String subject; //Subject of email
	private String text; //Body of email
	private String smtpServer; //Body of email
	
        public SendMailUtil(String smtp, String recipient, String senderEmail, String senderPassword, String subject, String text) {
		smtpServer = smtp;
		to = recipient;
		from = senderEmail;
		senderPass = senderPassword;
		this.subject = subject;
		this.text = text;
	}
	public void sendMail() {
		
		String host;
		if(smtpServer.equals("Gmail")) {
			host = "smtp.gmail.com"; //port = 465; ssl = true
		}
		else if(smtpServer.equals("Hotmail") || smtpServer.equals("Live")) {
			host = "smtp-mail.outlook.com"; //port 587; ssl = false; "mail.smtp.starttls.enable", "true"
		}
		else if(smtpServer.equals("Yahoo")) {
			host = "smtp.mail.yahoo.com"; //port = 465; ssl = true
		}
		else {//We do not support the smtpServer the user requested.
			//We should Probably throw an error here. 
			host = "";
		}
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        //If sender is "@yahoo.com"
	    //if(host.equals("smtp.yahoo.com") ) {
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
        //}
        
        //If sender is "@gmail.com"
	    if(host.equals("smtp.gmail.com")) {
        	properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        }
        
        //If sender is "@hotmail.com or @live.com"
	    if(host.equals("smtp-mail.outlook.com")) {
        	properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.ssl.enable", "false");
            properties.put("mail.smtp.auth", "true");
        	properties.put("mail.smtp.starttls.enable", "true");
        }

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, senderPass);
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

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
            message.setText(text);
            
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } 
        catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
