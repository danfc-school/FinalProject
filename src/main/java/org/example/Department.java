package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Department {
    //Fields
    private String departmentId;
    private String departmeentName;
    private static int nextId = 1;

    //Checker Method
    /**
     * Check if the department name is valid
     * Valid: Only letters and spaces
     * @param departmentName the department name in question
     * @return 
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null) {
            return false;
        }
        //For Loop
        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            
            if(Character.isLetter(c) == false && c != ' ') {
                return false;
            }
        }
        return true;

     //Constructor
     /**
     * Creates a Department using departmentName
     * If the department name is invalid, it'll result in null
     * @param departmentName department name
     */
    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName) == false) {
            this.departmentId = null;
            this.departmentName = null;
        }
        else {
            this.departmentName = departmentName;
            this.departmentId = "D0" + nextId;
            nextId = nextId + 1;
        }
    }
    //Getters
    /**
     * Gets all fields
     * @return the values stored in Department
     */
    public String getDepartmentId() {
        return departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public static int getNextId() {
        return nextId;
    }
    //Setters

    /**
     * Sets a new department name only if its valid
     * @param departmentName department name
     */
    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
        }
    }
    //toString Method
    /**
     * @return The department id and name
     */
    public String toString() {
        return "Department Id:" + departmentId +" Department Name:" + departmentName;
    }
    //Equals Method
    /**
     * Checks if 2 department objects are equals
     * @param obj  the reference object with which to compare.
     * @return that the departments are equals, otherwise returns false
     */
    public boolean equals (Object obj) {
        if (!(obj instanceof Department)) {
            return false;
        }
        Department other = (Department) obj;
        
        if (this.departmentId == null || other.departmentId == null) {
            return false;
        }
        
        return this.departmentId.equals(other.departmentId);
    }
}
