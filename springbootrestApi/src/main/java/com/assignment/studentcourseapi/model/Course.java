package com.assignment.studentcourseapi.model;

public class Course {

    private int id;
    private String title;
    private int duration;
    private double fee;

    public Course() {}

    public Course(int id, String title, int duration, double fee) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.fee = fee;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}