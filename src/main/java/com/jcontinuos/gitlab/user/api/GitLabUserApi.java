package com.jcontinuos.gitlab.user.api;

import com.jcontinuos.gitlab.user.dto.GitLabUser;
import com.jcontinuos.gitlab.user.service.GitLabUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/gitlab")
public class GitLabUserApi {

    @Autowired
    private GitLabUserService service;

    @GetMapping(value = "user")
    public GitLabUser findUser() throws Exception{
        return service.user();
    }

    @GetMapping(value = "users")
    public List<GitLabUser> findUsers() throws Exception{
        return service.users();
    }
}
