/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.culminating_robertchen;

/**
 *
 * @author julia
 */
public class Task {
    private String name;
    private String startTime;
    private String endTime;
    private String subtask1;
    private String subtask2;
    private String subtask3;
    private boolean repeating;
    private int number;
    
    public Task (String name, String startTime, String endTime, String subtask1, String subtask2, String subtask3, boolean repeating, int number) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subtask1 = subtask1;
        this.subtask2 = subtask2;
        this.subtask3 = subtask3;
        this.repeating = repeating;
        this.number = number;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getStartTime() {
        return startTime;
    }
    
    public String getEndTime() {
        return endTime;
    }
    
    public String getSubtask1() {
        return subtask1;
    }
    
    public String getSubtask2() {
        return subtask2;
    }
    
    public String getSubtask3() {
        return subtask3;
    }
    
    public boolean getRepeating() {
        return repeating;
    }
    
    public int getNumber() {
        return number;
    }
    
    // Setters
    public String setName(String n) {
        return name = n;
    }

    public String setStartTime(String st) {
        return startTime = st;
    }

    public String setEndTime(String et) {
        return endTime = et;
    }

    public String setSubtask1(String sb1) {
        return subtask1 = sb1;
    }

    public String setSubtask2(String sb2) {
        return subtask2 = sb2;
    }

    public String setSubtask3(String sb3) {
        return subtask3 = sb3;
    }

    public boolean setRepeating(boolean r) {
        return repeating = r;
    }
    
    @Override
    public String toString() {
        return name + ", " + startTime + ", " + endTime + ", " + subtask1 + ", " + subtask2 + ", " + subtask3
                + ", " + repeating + ", " + number + "\n";
    }
}
