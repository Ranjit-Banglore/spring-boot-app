package com.greenproject.service;

import com.greenproject.model.Project;
import com.greenproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectServiceImpl() {
    }

    @Override
    public List<Project> listAll() {
        List<Project> projects = new ArrayList<>();
        projectRepository.findAll().forEach(projects::add);
        return projects;
    }

    @Override
    public Project getById(int id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project saveOrUpdate(Project project) {
        if(projectRepository.existsById(project.getId())){
            projectRepository.deleteById(project.getId());
        }
        return projectRepository.save(project);
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void create(Project project) {

    }
}
