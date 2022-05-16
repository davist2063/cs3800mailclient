package mailClient;

import java.util.Properties;
import javax.mail.*;

public class RetrieveMail {
    private static String from = "cs3800emailtest@gmail.com"; //Sender email
    private static String senderPass = "test port 25"; //Sender password
    private static String storeType = "pop3s";
    private static String host = "pop.gmail.com";
    
    public RetrieveMail(String sender, String pass){
        from = sender;
        senderPass = pass;
    }
    
    public static Message[] receiveEmail(){
        Message[] email= new Message[100];
        Properties props = new Properties();
        props.put("mail.pop3.host",host);
        props.put("mail.pop3.port", 995);
        props.put("mail.pop3.starttles.enable", "true");
        props.put("mail.store.protocol", "pop3");
        
        Session session = Session.getInstance(props);
        //session.setDebug(true);
        try {
            Store mail = session.getStore(storeType);
            mail.connect(host, from, senderPass);
            
            Folder folder = mail.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            
            email = folder.getMessages();
            System.out.println("There are this many messages " + email.length);
            
            
            for (int i = 0; i < email.length; i++) {
                Message message = email[i];
                Address[] toAddress = 
                message.getRecipients(Message.RecipientType.TO);
                System.out.println();  
                //System.out.println("Email " + (i+1) + "-");  
                System.out.println("Subject - " + message.getSubject());  
                System.out.println("From - " + message.getFrom()[0]); 
 
                //System.out.println("To - "); 
                //for(int j = 0; j < toAddress.length; j++){
                  //  System.out.println(toAddress[j].toString());
                //}
                //System.out.println("Text - " + 
		   //message.getContent().toString());  
            }
 
            folder.close(false);
            mail.close();
            return email;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Could not retrieve email");
        }
        return email;
    }
    
    public static String[] populate() {
        String[] matrix = new String[100];
        Message[] email= new Message[100];
        Properties props = new Properties();
        props.put("mail.pop3.host",host);
        props.put("mail.pop3.port", 995);
        props.put("mail.pop3.starttles.enable", "true");
        props.put("mail.store.protocol", "pop3");
        
        Session session = Session.getInstance(props);
        //session.setDebug(true);
        try {
            Store mail = session.getStore(storeType);
            mail.connect(host, from, senderPass);
            
            Folder folder = mail.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            
            email = folder.getMessages();
            matrix = new String[email.length];
            
            for(int i = 0; i < email.length; i++){
                Message message = email[i];
                matrix[i] = message.getSubject();
            }
            return matrix;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Could not retrieve email");
        }
        return matrix;
    }
    
    public static void main(String[] args){
        receiveEmail();
    }
}
