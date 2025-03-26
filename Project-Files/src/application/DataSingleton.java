package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DataSingleton {

	private static final DataSingleton instance = new DataSingleton();
	private String userid;
	private DataSingleton() {}
	public static DataSingleton getInstance() {
		return instance;
	}
	
	public String getuserid(){
		return userid;
	}
	
	public void setuserid(String usr){
		userid = usr;
	}
	
	
}
