package org.example;

public class Course extends CourseFeatures implements CourseInterface {
    public Course(String courseName, String courseDescription){
        System.out.println("Course Constructor");

        super(courseName,courseDescription);
    }
    public String getAllCourses () {
        System.out.println("Course Name: " + getCourseName());
        System.out.println("Course Description: " + getCourseDescription());
        return "View Courses";
    }

    public String createCourse() {
        return "Courses created sucessfully";
    }

    public String updateCourse() {
        return "Courses updated sucessfully";
    }

    public String deleteCourse() {
        return "Courses deleted sucessfully";
    }
}
