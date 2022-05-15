//Implemented Way 1

package mailClient;

public class SendMail {
    public static String smtpServer;
    public static String to;
    public static String emailUser;
    public static String emailPassword;
    public static String subject;
    public static String body;
    
    public static void main(String[] args) {

    	//Creates Email Instance
    	SendMailUtil mailInformation;
    	
        
        mailInformation = new SendMailUtil(smtpServer, to, emailUser, emailPassword, subject, body); 
        
        //mailInformation.sendMail(); //Sends email.
    }
    
    public SendMail(String server, String rec, String user, String pass, String sub, String bod){
        smtpServer = server;
        to = rec;
        emailUser = user;
        emailPassword = pass;
        subject = sub;
        body = bod;
    }
    
    public void sendEmail(){
        SendMailUtil mailInformation;
        mailInformation = new SendMailUtil(smtpServer, to, emailUser, emailPassword, subject, body);
        mailInformation.sendMail(); //Sends email.
    }
    
    public SendMail(){
        //Information needed to send email
        smtpServer = "Gmail"; //Also works with "Yahoo", "Hotmail", and "Live"
        to = "sampleRecipient@gmail.com"; //Email of the Recipient
        emailUser = "sampleSender@gmail.com"; //Email of the Sender
        emailPassword = "password"; //Password of the Sender
        subject = "CS3800"; //Subject of the Email
        body = "This is a message"; //Contents of the Email.
    }
}
