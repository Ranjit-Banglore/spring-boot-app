package com.greenproject.service;

import com.greenproject.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> listAll();

    Project getById(int id);

    Project saveOrUpdate(Project project);

    void delete(int id);

    void addProject(Project project);
}
