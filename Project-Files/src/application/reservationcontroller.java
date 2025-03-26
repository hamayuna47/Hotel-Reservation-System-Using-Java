package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.sql.*;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class reservationcontroller implements Initializable {
	DataSingleton data = DataSingleton.getInstance();

	@FXML
	private Button button_res;
	
	@FXML
	private DatePicker tf_date;
	
	@FXML
	private TextField tf_roomid;

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
    private Label labelWelcome;

    @FXML
    private Label labelAccountInfo;
    

    @FXML
    private Button button_refresh;
    
    @FXML
    private TableView<Room> roomtable;
    @FXML
    private TableColumn<Room, String> idcol;
    @FXML
    private TableColumn<Room, String> roomtcol;
    @FXML
    private TableColumn<Room, String> bedcountcol;
    @FXML
    private TableColumn<Room, String> citycol;
    @FXML
    private TableColumn<Room, String> pricecol;
    
    

    String query = null;
    Connection connection = null ;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;
    Room room = null ;
    
    ObservableList<Room>  RoomList;
   
    public void getDate(ActionEvent event)
    {
    	LocalDate mydate = tf_date.getValue();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    	

        idcol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomtcol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        bedcountcol.setCellValueFactory(new PropertyValueFactory<>("bedCount"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
        citycol.setCellValueFactory(new PropertyValueFactory<>("city"));
        
        RoomList = DBUtils.getroom();
        roomtable.setItems(RoomList);
        
        
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
    	
    	button_manage.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenemanage(event, "manage.fxml", null, null);

			}
    		
			
			
    	});     
    	button_refresh.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				  try {
					  RoomList.clear();
					  
				        connection = DBUtils.dbconnect() ;

			            query = "SELECT * FROM room WHERE room_status = 'Available'";
			            preparedStatement = connection.prepareStatement(query);
			            resultSet = preparedStatement.executeQuery();
			            
			            
			            
			            while (resultSet.next() && resultSet!=null){
			            	RoomList.add(new  Room(
			            			resultSet.getInt("room_number"),
			                        resultSet.getString("room_type"),
			                        resultSet.getInt("bed_count"),
			                        resultSet.getString("room_status"),
			                        resultSet.getDouble("price"),
			                        resultSet.getString("city")));
			                
			            }
		            	roomtable.setItems(RoomList);

			            
			        } catch (SQLException ex) {
			        }
			        
			}
			
			
			
    	});     
    	
    	button_checkout.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScenecheckout(event, "checkout.fxml", null, null);

			}
    		
			
			
    	});     
    	
    	button_res.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
		    	LocalDate mydate = tf_date.getValue();
		    	if(tf_roomid!=null && mydate!=null) {
				  DBUtils.resroom(tf_roomid.getText(),mydate.toString(), data.getuserid());;
		    	}
			}
			
			
			
    	});     
    	
    	
    	
    	
    	}
  
}
