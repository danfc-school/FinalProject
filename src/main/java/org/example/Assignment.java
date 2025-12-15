package org.example;

import java.util.ArrayList;
import java.util.Random;

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
    //Generate Random Score
    /**
     * Generates random scores for students with a rule set
     * @param numberOfStudents numberof students that need a generated score
     */
    public void generateRandomScore(int numberOfStudents) {
        Random random = new Random();
        scores.clear();

        for(int i = 0; i < numberofStudents; i++) {
            int randomCategory = random.nextInt(11);
            int score;

            if (randomCategory == 0) {
                score = random.nextInt(60);
            }
            else if (randomCategory == 1 || randomCategory == 2) {
                score = 60 + random.nextInt(10);
            }
            else if (randomCategory == 3 || randomCategory == 4) {
                score = 70 + random.nextInt(10);
            }
            else if (randomCategory >= 5 && randomCategory <= 8) {
                score = 80 + random.nextInt(10);
            }
            else {
                score = 90 + random.nextInt(11);
            }
            scores.add(score);
        }
    }
    //String Method
    /**
     * The final string to represent the assignment
     * @return the final string
     */
    @Override
    public String toString() {
        return "Assignment ID:" + assignmentId + ", Name:" 
                + assignmentName + ", Weight:" + weight;
    }
}

