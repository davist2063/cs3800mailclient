package mailClient;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

//import javax.swing.Action;

/**
 * JavaFX App
 */
public class Main extends Application {

  
    @Override
    public void start(Stage stage) throws IOException {


        stage.setTitle("Sending email through SMTP server");

        Label title = new Label("SMTP server");
        TextField serverInput = new TextField();
        serverInput.setMaxWidth(300);

        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(300);

        Label passwordLabel = new Label("Password");
        TextField passwordField = new TextField();
        passwordField.setMaxWidth(300);

        Label recipientLabel = new Label("Recipient ");
        TextField recipientField = new TextField();
        recipientField.setMaxWidth(300);

        Label subjectLabel = new Label("Subject");
        TextField subjectField = new TextField();
        subjectField.setMinWidth(350);

        Label messageLabel = new Label("Message");
        TextField messageField = new TextField();
        messageField.setMinWidth(350);
        messageField.setMinHeight(150);

       

        Button cancel = new Button("Cancel");
        Button send = new Button("Send");
   

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

                //do stuff here
                
            }
        });
        
        send.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //create new mail object
                SendMail mail = new SendMail(serverInput.getText(), recipientField.getText(),
                        usernameField.getText(), passwordField.getText(), subjectField.getText(), messageField.getText());
                
                mail.sendEmail();
            }
        });

        HBox serverHB = new HBox( 10, title, serverInput);
        HBox usernameHB = new HBox(25, usernameLabel, usernameField);
        HBox passwordHB = new HBox(28, passwordLabel, passwordField);
        HBox recipientHB = new HBox(28, recipientLabel, recipientField);
        HBox subjectHB = new HBox(42, subjectLabel, subjectField);
        HBox messageHB = new HBox(33, messageLabel, messageField);
       


        VBox vbox = new VBox(10, serverHB, usernameHB, passwordHB, recipientHB, subjectHB, messageHB, cancel, send);
       
      
        //vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 500, 300);
        stage.setScene(scene);
        stage.show();

        


    }




    
    public static void main(String[] args) {
        launch(args);
    }


}
