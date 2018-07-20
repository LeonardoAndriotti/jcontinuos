package com.jcontinuos.gitlab.user.gateway;

import com.jcontinuos.gitlab.user.dto.GitLabUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GitLabGateway {

    private static final Logger log = LoggerFactory.getLogger(GitLabGateway.class);

    public GitLabUser getByUser(String url) {
        log.info("Buscando o usuário.");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, GitLabUser.class);
    }

    public List<GitLabUser> getAllUser(String url) {
        log.info("Buscando todos os usuários referentes ao token");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<GitLabUser>>() {
                }).getBody();

    }


}
