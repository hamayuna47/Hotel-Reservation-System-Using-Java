package application;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.*;

public class SampleController implements Initializable{

    @FXML
    private TextField tf_username;
    DataSingleton data = DataSingleton.getInstance();
    
    @FXML
    private TextField tf_pass;

    @FXML
    private Button button_login;

    @FXML
    private Button button_signup;

    
    @FXML
    public void loginButtonAction() {
        // Add your login logic here using tf_username and tf_password
        System.out.println("Login button clicked");
    }

    @FXML
    public void signupButtonAction() {
        System.out.println("Signup button clicked");
    }
    
   @Override
    public void initialize(URL location, ResourceBundle resources) {
		
    	button_login.setOnAction(new EventHandler<ActionEvent>()
    	{

			public void handle(ActionEvent event) {
	    		data.setuserid(tf_username.getText());
				if(tf_username != null && tf_pass != null ) {
				DBUtils.LoginUser(event, tf_username.getText(), tf_pass.getText());
				}
			}
    		
			
			
    	});
		button_signup.setOnAction(new EventHandler<ActionEvent>()
				{

					public void handle(ActionEvent event) {
						DBUtils.changeScene(event, "signup.fxml", null, null);
					}
			
				});
	}
}