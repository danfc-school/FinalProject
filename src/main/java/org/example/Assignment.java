package org.example;

import java.util.ArrayList;

public class Assignment {
    //Fields
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    //Constructor

    /**
     * Creates assignment with the name & weight
     * @param assignmentName assignment name
     * @param weight assignment weight
     */
    public Assignment(String assignmentName, double weight) {
        this.assignmentId = "A" + nextId;
        nextId++;
        
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>;
    }
    
    //Assignment Avg Method
    /**
     * Calculates the avg score of the assignement
     * If score is empty the average is 0
     * @return average score
     */
    public double calcAssignmentAvg() {
        if(scores.isEmpty()) {
            return 0;
        }
        int total = 0;
        for(int score : scores) {
            total += score;
        }
        return (double) total / scores.size();
    }
}

