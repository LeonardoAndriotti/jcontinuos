package com.jcontinuos.gitlab.user.service;

import com.jcontinuos.gitlab.user.dto.GitLabUser;
import com.jcontinuos.gitlab.user.gateway.GitLabGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitLabUserService {

    private static final String USER = "user";
    private static final String USERS = "users";

    @Autowired
    private GitLabGateway gitLabGateway;

    public GitLabUser user() throws Exception {
        return gitLabGateway.getByUser(formarUrl(USER));
    }

    public List<GitLabUser> users() throws Exception {
        return gitLabGateway.getAllUser(formarUrl(USERS));
    }

    private String formarUrl(String path) {
        //buscar aqui url e token no banco
        return String.format("%s/api/v4/%s?private_token=%s", "http://gitlab.anymarket.intranet", path, "TOKEN");
    }

}
