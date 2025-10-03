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

    public String updateCourse(Connection connection, int id, String courseName, String courseDescription) throws SQLException {
        setCourseName(courseName);
        setCourseDescription(courseDescription);

        String query = """
                UPDATE courses SET 
                    course_name = ?,
                    course_description = ?
                WHERE id = ?
                """;

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, getCourseName());
        statement.setString(2, getCourseDescription());
        statement.setInt(3, id);
        statement.executeUpdate();

        statement.close();
        return "Courses updated sucessfully";
    }

    public String deleteCourse(Connection connection) throws SQLException{
        return "Courses deleted sucessfully";
    }
}
