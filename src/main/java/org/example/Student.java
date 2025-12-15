package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Student {
    public enum Gender{
        MALE, FEMALE
    }

    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    //Helper Method
    /**
     * Generates the student Id
     * @return id
     */
    private String generateStudentID() {
        String id = String.format ("S%06d", nextId);
        nextId++;
        return id;
    }

    //Constructor
    /**
     * Creates a student with their ID being auto generated
     * @param studentName studentName
     * @param gender gender
     * @param address address
     * @param department department
     */
    public Student (String studentName, Gender gender, Address address, Department department) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }
      //Register Course
    /**
    * Registers a student for a course
    */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourse.add(course);
        course.getRegisteredStudents().add(this);
        
        for(int i = 0; i < course.getAssignements().size(); i++) {
            course.getScores(this).add(null);
        }
        return true;

}
