package application;

import java.sql.Timestamp;

public class Staff extends User {
    private String department;

    // Constructors
    public Staff() {
        // Call the default constructor of the superclass (User)
        super();
    }

    public Staff(int id,String username, String password, String email, String fullAddress, String department) {
        // Call the parameterized constructor of the superclass (User)
        super(id,username, password, email, fullAddress);
        this.department = department;
    }

    // Getter and Setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Override toString method to include department
    @Override
    public String toString() {
        return "Staff{" +
                "userId=" + getUserId() +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", fullAddress='" + getFullAddress() + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", department='" + department + '\'' +
                '}';
    }
}
