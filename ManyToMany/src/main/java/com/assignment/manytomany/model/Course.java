package com.assignment.manytomany.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnoreProperties("courses")
    private Set<Student> students = new HashSet<>();

    public Course() {}

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public int getDuration() { return duration; }
    public Set<Student> getStudents() { return students; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDuration(int duration) { this.duration = duration; }
}