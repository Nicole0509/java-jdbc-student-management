package org.example;

public class Course implements CourseInterface {
    public Course(){
        System.out.println("Course Constructor");
    }
    public String getAllCourses () {
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
