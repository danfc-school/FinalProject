package org.example;

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
}
