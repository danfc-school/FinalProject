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
    //Calc Average Method
    /**
     * Calculates average score for students
     * @return final averages for students
     */
    public int[] calcStudentAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);

                if (score != null) {
                    total += (score * a.getWeight()) / 100;
                }
            }
            averages[i] = (int) Math.round(total);
        }
        return averages;
    }
    //New Assignment Method
    /**
     * Adds a new assignment
     * @param assignmentName assignment's name
     * @param weight assignment's weight
     * @param maxScore max score possible
     * @return true if asssignment is added, false if it isnt
     */
    public boolean addAssignment(String assignmentName,double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight, maxScore);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }
        assignments.add(assignment);
        return true;
    }
    //Generating Scores Method

    /**
     * Gnerates random scores for registered students and assignments
     */
    public void displayScores() {
        Random random = new Random();

        for(int i = 0; i < registeredStudents.size(); i++) {
            int randomScore = random.nextInt(assignment.getMaxScore() + 1);

            assignment.getScores().set(i, randomScore);
        }
    }

    //Display Scores Method
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");
        System.out.println();

        System.out.print("Student Name\t");
        for (Assignment a : assignments) {
            System.out.print(a.getAssignmentName() + "\t");
        }

        System.out.println("Final Score");

        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.print(registeredStudents.get(i).getStudentName() + "\t");

            for (Assignment a : assignments) {
                System.out.print(a.getScores().get(i) + "\t");
            }

            System.out.println(finalScores[i]);
        }
    }
}
