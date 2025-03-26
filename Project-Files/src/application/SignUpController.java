package application;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SignUpController implements Initializable{

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField tf_pass;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_address;

    @FXML
    private RadioButton rb_customer;

    @FXML
    private RadioButton rb_staff;

    @FXML
    private Button button_signup;

    @FXML
    private Button button_login;

    @FXML
    public void initialize() {
        // Initialization code, if needed
    }

    @FXML
    private void handleSignUpButton() {
        String username = tf_username.getText();
        String password = tf_pass.getText();
        String email = tf_email.getText();
        String address = tf_address.getText();
        String userType = rb_customer.isSelected() ? "Type1" : "Type2";

        // Perform validation and database insertion logic here

        // Redirect to the appropriate FXML file (e.g., loggedIn.fxml) upon successful signup
    }

    @FXML
    private void handleLoginButton() {
        // Redirect to the login page (e.g., login.fxml)
    }

	@Override
    public void initialize(URL location, ResourceBundle resources) {
		
    	button_login.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScene(event, "Sample.fxml", null, null);

			}
    		
			
			
    	});
		button_signup.setOnAction(new EventHandler<ActionEvent>()
				{

					public void handle(ActionEvent event) {
						if(tf_username != null && tf_pass != null && tf_email!=null && tf_address!=null && rb_customer!=null) {
				        String userType = rb_customer.isSelected() ? "Type1" : "Type2";

						DBUtils.SignupUser(event, tf_username.getText(), tf_pass.getText(), tf_email.getText(),tf_address.getText() ,userType);
						}
	
					}
			
				});
	}
}
