//Implemented Way 1

package com.sendemail;

public class SendMail {

    public static void main(String[] args) {

    	//Creates Email Instance
    	SendMailUtil mailInformation;
    	//Information needed to send email
    	String smtpServer = "Gmail"; //Also works with "Yahoo", "Hotmail", and "Live"
        String to = "sampleRecipient@gmail.com"; //Email of the Recipient
        String emailUser = "sampleSender@gmail.com"; //Email of the Sender
        String emailPassword = "password"; //Password of the Sender
        String subject = "CS3800"; //Subject of the Email
        String body = "This is a message"; //Contents of the Email.
        
        mailInformation = new SendMailUtil(smtpServer, to, emailUser, emailPassword, subject, body); 
        
        mailInformation.sendMail(); //Sends email.
    }
}
