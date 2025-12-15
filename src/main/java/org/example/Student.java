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
    * @return true if it works, false if not registered
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
    //Drop Course
    /**
     * Drops a course for the student
     * @return true if it works, false if not registered
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);
        course.getRegistredStudents().remove(this);
        return true;
    }
    //Simplified String Methods
    /**
     * Converts the student to a simplified string
     * @return Simplified string
     */
    public String toSimplifiedString() {
        return studentId + " " + studentName + " " + department.getDepartmentName() + " ";
    }

    //String Methods
    /**
     * The final string to represent the student
     * @return result
     */
    public String toString() {

        String result = "";
        result += "Student ID:" + studentId;
        result += "\n" + "Name:" + studentName;
        result += "\n" + "Gender:" + gender;
        result += "\n" + "Address:" + address;
        result += "\n" + "Department:" + department;
        result += "\n" + "Registered Courses:";

        for (Course course : registeredCourses) {
            result += " " + course.getCourseId() + ", "
                    + course.getCourseName() + ", "
                    + course.getDepartment().getDepartmentName();

        }
        return result;
    }
}        
