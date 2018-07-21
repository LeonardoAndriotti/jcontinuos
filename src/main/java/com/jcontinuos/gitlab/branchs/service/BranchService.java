package com.jcontinuos.gitlab.branchs.service;

import com.jcontinuos.gitlab.branchs.dto.Branch;
import com.jcontinuos.gitlab.branchs.gateway.BranchGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BranchService {

    private static final String PROJECTS = "projects/";
    private static final String REPOSITORY_BRANCHES = "/repository/branches";
    private static final String BAR = "/";

    @Autowired
    private BranchGateway gateway;

    public List<Branch> findBranchByProjectsId(Long id) throws Exception {
        return gateway.getBranchsByProjectId(formarUrl(PROJECTS + id + REPOSITORY_BRANCHES, "TOKEN"));
    }

    public Branch findBranchByName(Long id, String name) throws Exception {
        return gateway.branchByName(formarUrl(PROJECTS + id + REPOSITORY_BRANCHES + BAR + name, "TOKEN"));
    }

    public Branch createBranch(Long id, String name) throws Exception {
        return gateway.createBranch(formarUrl(PROJECTS + id + REPOSITORY_BRANCHES, null), name, "master", "TOKEN");
    }

    public void deleteBranch(Long id, String name) throws Exception {
        gateway.deleteBranch(formarUrl(PROJECTS + id + REPOSITORY_BRANCHES + BAR + name, "TOKEN"));
    }

    private String formarUrl(String path, String token) {
        //buscar aqui url e token no banco
        if (Objects.isNull(token)) {
            return String.format("%s/api/v4/%s", "http://gitlab.anymarket.intranet", path);
        }
        return String.format("%s/api/v4/%s?private_token=%s", "http://gitlab.anymarket.intranet", path, token);
    }
}