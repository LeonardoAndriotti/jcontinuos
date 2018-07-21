package com.jcontinuos.gitlab.projects.service;

import com.jcontinuos.gitlab.projects.dto.Projects;
import com.jcontinuos.gitlab.projects.gateway.ProjectsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.info.InfoContributorProperties;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {

    @Autowired
    private ProjectsGateway gateway;

    public Projects findProjectById(Long id){
        return gateway.getProjectById(formarUrl("projects/"+id));
    }
    public List<Projects> findProjects(){
        return gateway.getAllProjects(formarUrl("projects"));
    }
    private String formarUrl(String path) {
        //buscar aqui url e token no banco
        return String.format("%s/api/v4/%s?private_token=%s", "http://gitlab.anymarket.intranet", path, "TOKEN");
    }
}
