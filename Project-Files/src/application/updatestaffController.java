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
import java.util.ResourceBundle;

public class updatestaffController implements Initializable {

	DataSingleton data = DataSingleton.getInstance();
    @FXML
    private Button button_about;

    @FXML
    private Button button_upd;

    @FXML
    private Button button_logout;


    @FXML
    private Button button_upda;
    

    @FXML
    private Button button_ref;
    

    @FXML
    private Button button_report;
    
    
    @FXML
    private TextField tf_roomno;
    

    @FXML
    private TextField tf_price;
    

    @FXML
    private TextField tf_status;
    
    
    @FXML
    private Label tf_welcome;

    @FXML
    private Label labelAccountInfo;


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
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	


        idcol.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        roomtcol.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        bedcountcol.setCellValueFactory(new PropertyValueFactory<>("bedCount"));
        pricecol.setCellValueFactory(new PropertyValueFactory<>("price"));
        citycol.setCellValueFactory(new PropertyValueFactory<>("roomStatus"));
        
        RoomList = DBUtils.getroomall();
        roomtable.setItems(RoomList);
        
        

    	button_about.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeSceneloginst(event, "loggedinstaff.fxml", null, null);

			}
    		
			
			
    	});      
    	
    	button_upd.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeSceneloginstup(event, "updatestaff.fxml", null, null);

			}
    		
			
			
    	}); 
    	
    	
    	button_report.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeSceneloginstrp(event, "reportstaff.fxml", null, null);

			}
    		
			
			
    	});      
   
    	button_ref.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {

		        RoomList = DBUtils.getroomall();
		        roomtable.setItems(RoomList);
			}
    		
			
			
    	});      
    	
    	button_upda.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				
				if(tf_roomno!=null)
				{
					
					
					
						DBUtils.updatestatus(tf_roomno.getText() , tf_status.getText());
					
						DBUtils.updateprice(tf_roomno.getText() , tf_price.getText());

					
					
				}

			}
    		
			
			
    	});     
       
    	button_logout.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				DBUtils.changeScene(event, "Sample.fxml", null, null);

			}
    		
			
			
    	});          
    	
    	
    	
    	}

  
}
