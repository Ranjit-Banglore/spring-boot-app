package com.greenproject.controller;

import com.greenproject.model.Project;
import com.greenproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    @RequestMapping("/projects")
    public List<Project> listProjects(){
        return projectService.listAll();
    }

}
