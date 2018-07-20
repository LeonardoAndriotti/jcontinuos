package com.jcontinuos.gitlab.projects.gateway;

import com.jcontinuos.gitlab.projects.dto.Projects;
import com.jcontinuos.gitlab.user.dto.GitLabUser;
import com.jcontinuos.gitlab.user.gateway.GitLabGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ProjectsGateway {

    private static final Logger log = LoggerFactory.getLogger(ProjectsGateway.class);

    public Projects getProjectById(String url) {
        log.info("Buscando o usuário.");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Projects.class);
    }

    public List<Projects> getAllProjects(String url) {
        log.info("Buscando todos os usuários referentes ao token");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://gitlab.anymarket.intranet/api/v4/projects?private_token=TOKEN",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Projects>>() {
                }).getBody();
    }

}
