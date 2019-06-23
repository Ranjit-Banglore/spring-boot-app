package com.greenproject.controller;

import com.greenproject.model.Project;
import com.greenproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("/all")
    public List<Project> listProjects() {
        return projectService.listAll();
    }

    @RequestMapping("/{id}")
    public Project getById(@PathVariable Integer id) {
        return projectService.getById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Project create(@RequestBody Project project) {
        return projectService.saveOrUpdate(project);
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable int id) {
        projectService.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void saveOrUpdateById(@RequestBody Project project) {
        projectService.saveOrUpdate(project);
    }
}
