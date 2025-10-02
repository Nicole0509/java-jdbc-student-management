package org.example;
import com.sun.nio.sctp.AbstractNotificationHandler;

import java.sql.*;

public class Student {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public  Student(String firstName, String lastName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String addStudent(Connection connection) throws SQLException {

        String query = "INSERT INTO students (first_name,last_name,email,date_of_birth) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, this.firstName);
        statement.setString(2, this.lastName);
        statement.setString(3, this.email);
        statement.setDate(4, this.dateOfBirth);
        statement.executeUpdate();

        statement.close();

        return "Student created sucessfully!";
    }

    public String updateStudent(Connection connection, int id, String firstName, String lastName, String email, Date dateOfBirth) throws SQLException {
        String query = """
                UPDATE students SET 
                    first_name = ?,
                    last_name = ?,
                    email = ?,
                    date_of_birth = ?
                WHERE id = ?
                """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.setString(3, email);
        statement.setDate(4, dateOfBirth);
        statement.setInt(5, id);
        statement.executeUpdate();

        int rowsUpdated = statement.executeUpdate();

        statement.close();

        return rowsUpdated > 0 ? "Student updated successfully!" : "No student found with that ID.";
    }

    public String deleteStudent(Connection connection, int id) throws SQLException {
        String query = """
                DELETE FROM students WHERE id = ?
        """;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();

        return "Student deleted successfully!";
    }

    public String getAllStudents(Connection connection) throws SQLException {
        String query = "SELECT * FROM students";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            Date dateOfBirth = resultSet.getDate("date_of_birth");

            System.out.println(id + " " + firstName + " " + lastName + " " + email + " " + dateOfBirth);
        }
        return "";
    }
}
