package application;
import java.sql.Date;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int reservationId;
    private String userId;
    private int roomNumber;
    private Date reservationDate;

    // Constructors
    public Reservation() {
    }

    public Reservation(int reservid, String userId, int roomNumber, Date date) {
        this.reservationId = reservid;
    	this.userId = userId;
        this.roomNumber = roomNumber;
        this.reservationDate = date;
    }

    // Getters and Setters
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", userId='" + userId + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
