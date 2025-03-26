package application;

public class Occupancy {
    private int occupancyId;
    private String userId;
    private int roomNumber;

    // Constructors
    public Occupancy() {
    }

    public Occupancy(int id,String userId, int roomNumber) {
        occupancyId = id;
    	this.userId = userId;
        this.roomNumber = roomNumber;
    }

    // Getters and Setters
    public int getOccupancyId() {
        return occupancyId;
    }

    public void setOccupancyId(int occupancyId) {
        this.occupancyId = occupancyId;
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

    @Override
    public String toString() {
        return "Occupancy{" +
                "occupancyId=" + occupancyId +
                ", userId='" + userId + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
