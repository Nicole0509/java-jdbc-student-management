package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Course extends CourseFeatures implements CourseInterface {
    public Course(String courseName, String courseDescription){
        System.out.println("Course Constructor");

        super(courseName,courseDescription);
    }
    public String getAllCourses (Connection connection) throws SQLException {

        return "View Courses";
    }

    public String createCourse(Connection connection) throws SQLException {
        String query = "INSERT INTO courses (course_name,course_description) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, getCourseName());
        statement.setString(2, getCourseDescription());
        statement.executeUpdate();

        statement.close();
        return "Courses created sucessfully";
    }

    public String updateCourse() {
        return "Courses updated sucessfully";
    }

    public String deleteCourse() {
        return "Courses deleted sucessfully";
    }
}
