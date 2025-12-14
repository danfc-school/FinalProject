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

}
