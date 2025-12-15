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
    /**
     * Generates Course Id
     * @return generated course Id
     */
    private String generateCourseId() {
        String id = String.format("C-%s-%02d", department.getDepartmentId(), nextId);
        return id;
    }
        
    //Assignment Weight Validation Method
    /**
     * Checks if total weight of assignments = 100
     * @return if assignments = 100 or not
     */
    public boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        
        for(Assignment a : assignments) {
            totalWeight += a.getWeight();
        }
        return totalWeight == 100;
    }

    //Register Student Method
    /**
     * Registers students into the course
     * Adds null for each assignment
     * @param student the student thats getting registered
     * @return true if registration is successful, false if it isn't
     */
    public boolean registerStudent(Student student) {
        if(student == null) {
            return false;
        }
        registeredStudents.add(student);
        for (Assignment a : assignments) {
            a.getScores().add(null);
        }
        return true;
    }
}
