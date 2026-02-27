package com.assignment.employeeprojectapi.controller;

import com.assignment.employeeprojectapi.model.Project;
import com.assignment.employeeprojectapi.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public List<Project> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Project create(@RequestBody Project project) {
        return service.save(project);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Project Deleted";
    }
}