package org.example;

import java.util.ArrayList;

    //Fields
    public class Course {
        private String courseId;
        private String courseName;
        private double credits;
        private Department department;
        private ArrayList<Assignment> assignments;
        private ArrayList<Student> registeredStudents;
        private static int nextId = 1;

    //Constructor
    public Course(String courseName, double credits, Department department) {
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;

        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.courseId = generateCourseId();
    }

    //Helper Method
    private String generateCourseId() {
        String id = String.format("C-%s-%02d", department.getDepartmentId(), nextId);
        return id;
    }
}
