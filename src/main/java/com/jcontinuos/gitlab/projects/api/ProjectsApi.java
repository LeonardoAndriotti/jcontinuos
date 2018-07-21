package com.jcontinuos.gitlab.projects.api;

import com.jcontinuos.gitlab.projects.dto.Projects;
import com.jcontinuos.gitlab.projects.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/gitlab")
public class ProjectsApi {

    @Autowired
    private ProjectsService service;

    @GetMapping(value = "/projects")
    public List<Projects> findProjects(){
        return service.findProjects();
    }

    @GetMapping(value = "/project/{id}")
    public Projects findProjectById(@PathVariable("id") Long id){
        return service.findProjectById(id);
    }
}
