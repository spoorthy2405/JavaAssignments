package com.assignment.employeeprojectapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private double budget;
    private String client;

    public Project() {}

    public Project(String title, double budget, String client) {
        this.title = title;
        this.budget = budget;
        this.client = client;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public double getBudget() { return budget; }
    public String getClient() { return client; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setBudget(double budget) { this.budget = budget; }
    public void setClient(String client) { this.client = client; }
}