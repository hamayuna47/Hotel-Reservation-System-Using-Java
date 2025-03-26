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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class checkincontroller implements Initializable {
	DataSingleton data = DataSingleton.getInstance();

    @FXML
    private Button button_about;
    

    @FXML
    private Button button_check;

    

    @FXML
    private Button button_checkout;


    @FXML
    private Button button_ref;

    @FXML
    private Button button_reservation;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_checkin;

    @FXML
    private Button button_manage;

    @FXML
    private Label labelWelcome;

    @FXML
    private Label labelAccountInfo;
    
    

    @FXML
    private TableView<Reservation> reservationtable;
    @FXML
    private TableColumn<Reservation, String> usercol;
    @FXML
    private TableColumn<Reservation, String> roomcol;
    @FXML
    private TableColumn<Reservation, String> rdcol;
    @FXML
	private TextField tf_roomno;

    

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Room room = null ;
    
    ObservableList<Reservation>  ReservationList;
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	


        usercol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        roomcol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        rdcol.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));
    	

        ReservationList = DBUtils.getreservation(data.getuserid());
        reservationtable.setItems(ReservationList);
        
        
    	
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
    	button_ref.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {

				
				        ReservationList = DBUtils.getreservation(data.getuserid());
				        reservationtable.setItems(ReservationList);
				        
			       
			}
    		
			
			
    	});     
    	
    	button_check.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				if(tf_roomno!=null) {
				  DBUtils.roomcheckin(tf_roomno.getText(), data.getuserid());;
				}
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
