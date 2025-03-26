package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.*;
import java.io.IOException;
import java.sql.*;


public class Room {
    private int roomNumber;
    private String roomType;
    private int bedCount;
    private String roomStatus;
    private double price;
    private String city;

    // Constructors
    public Room() {
        // Default constructor
    }

    public Room(int roomNumber, String roomType, int bedCount, String roomStatus, double price, String city) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedCount = bedCount;
        this.roomStatus = roomStatus;
        this.price = price;
        this.city = city;
    }

    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", bedCount=" + bedCount +
                ", roomStatus='" + roomStatus + '\'' +
                ", price=" + price +
                ", city='" + city + '\'' +
                '}';
    }
}
