package com.assignment.employeeprojectapi.service;

import com.assignment.employeeprojectapi.model.Project;
import com.assignment.employeeprojectapi.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> getAll() {
        return repository.findAll();
    }

    public Project getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Project save(Project project) {
        return repository.save(project);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}