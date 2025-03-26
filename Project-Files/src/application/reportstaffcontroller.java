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

public class reportstaffcontroller implements Initializable {

	DataSingleton data = DataSingleton.getInstance();
    @FXML
    private Button button_about;

    @FXML
    private Button button_upd;

    @FXML
    private Button button_logout;


    @FXML
    private Button button_report;


    @FXML
    private Button button_rooms;


    @FXML
    private Button button_rrooms;


    @FXML
    private Button button_orooms;


    @FXML
    private Button button_feeb;

    
    
    
    @FXML
    private Label tf_welcome;

    @FXML
    private Label labelAccountInfo;


    

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	tf_welcome.setText("Welcome "+ data.getuserid());
    	

    	
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
       
    	button_rooms.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				if(data.getuserid().contains("user4"))
				{
				DBUtils.reportrooms();
				}
			}
    		
			
			
    	}); 
    	
    	button_rrooms.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				if(data.getuserid().contains("user4"))
				{
				DBUtils.reportrrooms();
				}
			}
    		
			
			
    	}); 
    	
    	button_orooms.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				if(data.getuserid().contains("user4"))
				{
				DBUtils.reportorooms();
				}
			}
    		
			
			
    	}); 
    	
    	button_feeb.setOnAction(new EventHandler<ActionEvent>()
    	{

    		
			public void handle(ActionEvent event) {
				if(data.getuserid().contains("user4"))
				{
				DBUtils.reportfb();
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
