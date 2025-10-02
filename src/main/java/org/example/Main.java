package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalDate;

public class Main {

    static String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    static String USER = "postgres";
    static String PASSWORD = "Nicole0509";

    static String firstName = "Igire";
    static String lastName = "Rwanda";
    static String email = "Igire@gmail.com";
    static Date dateOfBirth = Date.valueOf(LocalDate.now());

    public static void main(String[] args) throws SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Student Management with Java\n");

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        Student student = new Student(firstName, lastName, email, dateOfBirth);

        if (connection != null) {
            System.out.println(student.addStudent(connection));
        } else  {
            System.out.println("Failed to connect to database.");
        }
    }
}