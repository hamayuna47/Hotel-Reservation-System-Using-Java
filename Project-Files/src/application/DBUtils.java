package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import javax.swing.JOptionPane;


public class DBUtils {

	public static Connection dbconnect()
	{
		Connection conn=null;
		 try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				return conn;
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	        }
	            		
	}
	
	public static ObservableList<Room> getroom()
	{
		Connection conn = dbconnect();
		ObservableList<Room> list = FXCollections.observableArrayList();
		
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM room WHERE room_status = 'Available'");
		ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new  Room(
	        			rs.getInt("room_number"),
	                    rs.getString("room_type"),
	                    rs.getInt("bed_count"),
	                    rs.getString("room_status"),
	                    rs.getDouble("price"),
	                    rs.getString("city")));
			}
			
		}catch (Exception e) {}
		return list;
	}
	
	
	public static ObservableList<Room> getroomall()
	{
		Connection conn = dbconnect();
		ObservableList<Room> list = FXCollections.observableArrayList();
		
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM room");
		ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new  Room(
	        			rs.getInt("room_number"),
	                    rs.getString("room_type"),
	                    rs.getInt("bed_count"),
	                    rs.getString("room_status"),
	                    rs.getDouble("price"),
	                    rs.getString("city")));
			}
			
		}catch (Exception e) {}
		return list;
	}
	
	public static ObservableList<Reservation> getreservation(String useri)
	{
		Connection conn = dbconnect();
		ObservableList<Reservation> list = FXCollections.observableArrayList();
		
		try {
			    String query = "SELECT * FROM reservation WHERE user_id = ?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, useri);		
	            ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new  Reservation(
	        			rs.getInt("reservation_id"),
	                    rs.getString("user_id"),
	                    rs.getInt("room_number"),
	                    rs.getDate("reservation_date")));
			}
			
		}catch (Exception e) {}
		return list;
	}
	
	
	public static ObservableList<Occupancy> getoccupancy(String useri)
	{
		Connection conn = dbconnect();
		ObservableList<Occupancy> list = FXCollections.observableArrayList();
		
		try {
			    String query = "SELECT * FROM occupancy WHERE user_id = ?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, useri);		
	            ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new  Occupancy(
	        			rs.getInt("occupancy_id"),
	                    rs.getString("user_id"),
	                    rs.getInt("room_number")));
			}
			
		}catch (Exception e) {}
		return list;
	}
	
	
	public static ObservableList<User> getuser(String useri)
	{
		Connection conn = dbconnect();
		ObservableList<User> list = FXCollections.observableArrayList();
		
		try {
			    String query = "SELECT * FROM users WHERE username = ?";
	            PreparedStatement ps = conn.prepareStatement(query);
	            ps.setString(1, useri);		
	            ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				list.add(new  User(
	        			rs.getInt("user_id"),
	                    rs.getString("username"),
	                    rs.getString("password"),
	                    rs.getString("email"),
	                    rs.getString("full_address")));
			}
			
		}catch (Exception e) {}
		return list;
	}
	
	public static void reportrooms()
	{
		Connection conn = dbconnect();
        String filePath = "rooms.txt";

		
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM room");
		ResultSet rs = ps.executeQuery();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

			while(rs.next())
			{
				String datas = 
	        			rs.getString("room_number") + "\t" +
	                    rs.getString("room_type") + "\t" +
	                    rs.getString("bed_count") + "\t" +
	                    rs.getString("room_status") + "\t" +
	                    rs.getString("price") + "\t" +
	                    rs.getString("city") + "\n" ;
				writer.write(datas);
				System.out.println(datas);
			}
			
			writer.flush();
            writer.close();

			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Generation Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Report was successfully Generated.");
	        alert.showAndWait();
			
		}catch (Exception e) {}
	}
	
	public static void reportrrooms()
	{
		Connection conn = dbconnect();
        String filePath = "reservations.txt";

		
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservation ");
		ResultSet rs = ps.executeQuery();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

			while(rs.next())
			{
				String datas = 
	        			rs.getString("reservation_id") + "\t" +
	                    rs.getString("user_id") + "\t" +
	                    rs.getString("room_number") + "\t" +
	                    rs.getString("reservation_date") + "\n" ;
				writer.write(datas);
				System.out.println(datas);
			}
			
			writer.flush();
            writer.close();

			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Generation Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Report was successfully Generated.");
	        alert.showAndWait();
			
		}catch (Exception e) {}
	}
	
	
	public static void reportorooms()
	{
		Connection conn = dbconnect();
        String filePath = "occupancy.txt";

		
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM occupancy ");
		ResultSet rs = ps.executeQuery();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

			while(rs.next())
			{
				String datas = 
	        			rs.getString("occupancy_id") + "\t" +
	                    rs.getString("user_id") + "\t" +
	                    rs.getString("room_number") + "\n";
				writer.write(datas);
				System.out.println(datas);
			}
			
			writer.flush();
            writer.close();

			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Generation Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Report was successfully Generated.");
	        alert.showAndWait();
			
		}catch (Exception e) {}
	}
	
	
	public static void reportfb()
	{
		Connection conn = dbconnect();
        String filePath = "feedback.txt";

		
		try {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM feedback ");
		ResultSet rs = ps.executeQuery();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

			while(rs.next())
			{
				String datas = 
	        			rs.getString("feedback_id") + "\t" +
	                    rs.getString("user_id") + "\t" +
	                    rs.getString("room_number") + "\t"+
	                    rs.getString("description") + "\n" ;
;
				writer.write(datas);
				System.out.println(datas);
			}
			
			writer.flush();
            writer.close();

			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Generation Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Report was successfully Generated.");
	        alert.showAndWait();
			
		}catch (Exception e) {}
	}
	
	
	
	
	
	public static void resroom(String roomnumber, String date, String userid)
	{
		Connection conn = dbconnect();
		
		try {
		String query = "UPDATE room SET room_status = ? WHERE room_number = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, "Reserved");
        ps.setString(2, roomnumber);
        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Reservation Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Reservation was successful.");
	        alert.showAndWait();
	        
	        
	        query = "INSERT INTO reservation (user_id, room_number, reservation_date) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, userid);
            ps.setInt(2, Integer.parseInt(roomnumber));
            ps.setString(3, date);

            // Execute the insert
            ps.executeUpdate();
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    } 
	}
	
	
	public static void updatestatus(String roomnumber, String status)
	{
		if(!status.isBlank()) {
		Connection conn = dbconnect();
		
		try {
			System.out.println(roomnumber);
			System.out.println(status);

			String query = "UPDATE room SET room_status = ? WHERE room_number = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, status);
        ps.setString(2, roomnumber);
        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Update Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Status was successfully Updated.");
	        alert.showAndWait();
	        
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    } 
		}
	}
	

	public static void updateprice(String roomnumber, String price)
	{
		if(!price.isBlank())
		{
		Connection conn = dbconnect();
		
		try {
		String query = "UPDATE room SET price = ? WHERE room_number = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, price);
        ps.setString(2, roomnumber);
        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Update Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Price was successfully Updated.");
	        alert.showAndWait();
	        
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    }
		}
	}
	
	
	
	
	public static void roomcheckin(String roomnumber, String userid)
	{
		Connection conn = dbconnect();
		
		try {
		String query = "UPDATE room SET room_status = ? WHERE room_number = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, "Occupied");
        ps.setString(2, roomnumber);
        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("CheckIn Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your CheckIn was successful.");
	        alert.showAndWait();
	        
	        
	        query = "DELETE FROM reservation WHERE user_id = ? AND room_number = ?";;
            ps = conn.prepareStatement(query);

            ps.setString(1, userid);
            ps.setString(2, roomnumber);

            // Execute the insert
            ps.executeUpdate();
            
            
            
            query = "INSERT INTO occupancy (user_id, room_number) VALUES (?, ?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, userid);
            ps.setString(2, roomnumber);

            // Execute the insert
            ps.executeUpdate();
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    } 
	}
	
	
	public static void roomcheckout(String roomnumber, String userid , String feedb , double stars)
	{
		Connection conn = dbconnect();
		
		try {
		String query = "UPDATE room SET room_status = ? WHERE room_number = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, "Available");
        ps.setString(2, roomnumber);
        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("CheckOut Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your CheckOut was successful.");
	        alert.showAndWait();
	        
	        
	        query = "DELETE FROM occupancy WHERE user_id = ? AND room_number = ?";;
            ps = conn.prepareStatement(query);

            ps.setString(1, userid);
            ps.setString(2, roomnumber);

            // Execute the insert
            ps.executeUpdate();
            
            
            if(!feedb.isBlank())
            {
            	query = "INSERT INTO feedback (user_id, room_number, description , stars) VALUES (?, ?, ?,?)";
            	ps = conn.prepareStatement(query);

                ps.setString(1, userid);
                ps.setString(2, roomnumber);
                ps.setString(3, feedb);
                ps.setDouble(4, stars);



                // Execute the insert
                ps.executeUpdate();
            	
            }
            
         
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    } 
	}
	
	

	public static void roomcancel(String roomnumber, String userid)
	{
		Connection conn = dbconnect();
		
		try {
		String query = "UPDATE room SET room_status = ? WHERE room_number = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, "Available");
        ps.setString(2, roomnumber);
        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Cancellation Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Reservation was Cancelled.");
	        alert.showAndWait();
	        
	        
	        query = "DELETE FROM reservation WHERE user_id = ? AND room_number = ?";;
            ps = conn.prepareStatement(query);

            ps.setString(1, userid);
            ps.setString(2, roomnumber);

            // Execute the insert
            ps.executeUpdate();
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    } 
	}

	public static void resup(String roomnumber, String userid,String dat)
	{
		Connection conn = dbconnect();
		
		try {
		String query = "UPDATE reservation SET reservation_date = ? WHERE room_number = ? and user_id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, dat);
        ps.setString(2, roomnumber);
        ps.setString(3, userid);

        
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Update Successful");
	        alert.setHeaderText(null);
	        alert.setContentText("Your Reservation was Updated.");
	        alert.showAndWait();
	        
			
		}
		}catch (SQLException ex) {
	        // Handle any SQL exceptions
	        ex.printStackTrace();
	    } 
	}
	
	
	
	public static void changeScene(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				SampleController loggedInController = (SampleController) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	
	
	public static void changeScenelogin(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				LoggedInController loggedInController = (LoggedInController) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	

	public static void changeSceneloginst(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				LoggedInControllerstaff loggedInController = (LoggedInControllerstaff) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	

	public static void changeSceneloginstup(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				updatestaffController loggedInController = (updatestaffController) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	public static void changeSceneloginstrp(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				reportstaffcontroller loggedInController = (reportstaffcontroller) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	
	public static void changeScenereservation(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				reservationcontroller loggedInController = (reservationcontroller) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	public static void changeScenecheckin(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				checkincontroller loggedInController = (checkincontroller) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	
	public static void changeScenecheckout(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				checkoutcontroller loggedInController = (checkoutcontroller) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	
	
	public static void changeScenemanage(ActionEvent event, String fxmlFile, String username, String password)
	{
		Parent root = null;
		
		if(username!=null)
		{
			try {
				FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
				root = loader.load();
				managecontroller loggedInController = (managecontroller) loader.getController();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
			} catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.setTitle("Hotel Management System");
		stage.setScene(new Scene(root,600,400));
		stage.show();
	}
	
	
	
	
	public static void SignupUser(ActionEvent event, String username, String password, String email, String address, String Types)
	{
		Connection connection = null;
		PreparedStatement psInsert = null;
		PreparedStatement checkuser = null;
		ResultSet resultSet = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			checkuser = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
			checkuser.setString(1, username);
			resultSet = checkuser.executeQuery();
			if(resultSet.isBeforeFirst())
			{
				System.out.println("User already exists!");
				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setContentText("You cannot use this username.");
				alert.show();
			}
			else
			{
				psInsert = connection.prepareStatement("INSERT INTO users (username,password, email,full_address,Utype)  VALUES(?, ?, ?, ?,?)");
				psInsert.setString(1, username);
				psInsert.setString(2, password);
				psInsert.setString(3, email);
				psInsert.setString(4, address);
				psInsert.setString(5, Types);

				psInsert.executeUpdate();
				
				Alert alert = new Alert(AlertType.INFORMATION);
		        alert.setTitle("Signup Successful");
		        alert.setHeaderText(null);
		        alert.setContentText("Congratulations! Your signup was successful.");
		        alert.showAndWait();

			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(checkuser!=null)
			{
				try
				{
					checkuser.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(psInsert!=null)
			{
				try
				{
					psInsert.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void LoginUser(ActionEvent event, String username, String password) {
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultset = null;

	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
	        preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
	        preparedStatement.setString(1, username);
	        resultset = preparedStatement.executeQuery();

	        if (!resultset.next()) {
	            System.out.println("User not found");
	            Alert alert = new Alert(Alert.AlertType.ERROR);
	            alert.setContentText("Credentials are incorrect.");
	            alert.show();
	        } else {
	            String storedPassword = resultset.getString("password");

	            if (storedPassword.equals(password)) {
	            	String temp = resultset.getString("Utype");
	            	String temp2 ="Type1"; 
	            	
	            	if(temp.contains(temp2))
	            	{
	                changeScenelogin(event, "loggedin.fxml", username, password);
	            	}
	            	else
	            	{
		                changeSceneloginst(event, "loggedinstaff.fxml", username, password);
	            	}
	            } else {
	                System.out.println("Password does not match");
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setContentText("Credentials are incorrect.");
	                alert.show();
	            }
	        }
	    }catch(SQLException e){
			e.printStackTrace();
		}
		finally
		{
			if(resultset!=null)
			{
				try
				{
					resultset.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try
				{
					preparedStatement.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try
				{
					connection.close();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
	}
}