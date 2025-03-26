package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

	DataSingleton data = DataSingleton.getInstance();
    @FXML
    private Button button_about;

    @FXML
    private Button button_reservation;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_checkin;
    

    @FXML
    private Button button_checkout;


    @FXML
    private Button button_manage;

    @FXML
    private Label tf_welcome;

    @FXML
    private Label labelAccountInfo;


    @FXML
    private TableView<User> tableusers;
    @FXML
    private TableColumn<User, String> idcol;
    @FXML
    private TableColumn<User, String> namecol;
    @FXML
    private TableColumn<User, String> emailcol;

    @FXML
    private TableColumn<User, String> addresscol;
    
    

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Room room = null ;
    
    ObservableList<User>  UserList;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	tf_welcome.setText("Welcome "+ data.getuserid());
    	

        idcol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("username"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addresscol.setCellValueFactory(new PropertyValueFactory<>("fullAddress"));


        UserList = DBUtils.getuser(data.getuserid());
        tableusers.setItems(UserList);
    	
    	button_about.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenelogin(event, "loggedin.fxml", null, null);

			}
    		
			
			
    	});        
    	button_reservation.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenereservation(event, "reservation.fxml", null, null);

			}
    		
			
			
    	});         
    	button_logout.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScene(event, "Sample.fxml", null, null);

			}
    		
			
			
    	});          
    	
    	
    	button_checkin.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenecheckin(event, "checkin.fxml", null, null);

			}
    		
			
			
    	});     
    	
    	button_checkout.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenecheckout(event, "checkout.fxml", null, null);

			}
    		
			
			
    	});     
    	
    	button_manage.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenemanage(event, "manage.fxml", null, null);

			}
    		
			
			
    	});     
    	}

  
}
