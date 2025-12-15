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
}

