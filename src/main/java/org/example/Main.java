package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String URL = "jdbc:postgresql://localhost:5432/postgres?currentSchema=public";
    static String USER = "postgres";
    static String PASSWORD = "Nicole0509";

    public static void main(String[] args) throws SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Student Management with Java\n");

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        if (connection != null) {
            System.out.println("Successfully connected to database.");
        } else  {
            System.out.println("Failed to connect to database.");
        }
    }
}