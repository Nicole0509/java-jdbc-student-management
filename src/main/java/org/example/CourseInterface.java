package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public interface CourseInterface {
    String getAllCourses (Connection connection) throws SQLException;
    String createCourse(Connection connection) throws SQLException;
    String updateCourse(Connection connection) throws SQLException;
    String deleteCourse(Connection connection) throws SQLException;
}
