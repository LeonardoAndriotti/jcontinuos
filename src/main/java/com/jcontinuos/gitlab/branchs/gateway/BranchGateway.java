package com.jcontinuos.gitlab.branchs.gateway;

import com.jcontinuos.gitlab.branchs.dto.Branch;
import com.jcontinuos.gitlab.projects.dto.Projects;
import com.jcontinuos.gitlab.projects.gateway.ProjectsGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class BranchGateway {

    private static final Logger log = LoggerFactory.getLogger(BranchGateway.class);

    public Branch branchByName(String url) throws Exception {
        log.info("Buscando branch");
        Branch branch = new Branch();
        try {
            RestTemplate restTemplate = new RestTemplate();
            branch = restTemplate.getForObject(url, Branch.class);
        } catch (Exception ex) {
            if (ex.getMessage().matches("404 Not Found")) {
                throw new Exception("Projeto não encontrado");
            }
            throw new Exception(ex.getMessage());
        }


        return branch;
    }

    public List<Branch> getBranchsByProjectId(String url) throws Exception {
        log.info("Buscando todas as branchs referentes ao projeto");
        RestTemplate restTemplate = new RestTemplate();
        List<Branch> branches = null;
        try {
            branches = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Branch>>() {
                    }).getBody();
        } catch (Exception ex) {
            if (ex.getMessage().matches("404 Not Found")) {
                throw new Exception("Projeto não encontrado");
            }
            throw new Exception(ex.getMessage());
        }
        return branches;
    }

    public Branch createBranch(String url, String name, String ref, String token) throws Exception {
        log.info("Criando branch");
        Branch branch = new Branch();
        try {
            RestTemplate restTemplate = new RestTemplate();
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            map.add("branch", name);
            map.add("ref", ref);
            map.add("private_token", token);
            branch = restTemplate.postForObject(url, map, Branch.class);
        } catch (Exception ex) {
            if (ex.getMessage().matches("404 Not Found")) {
                throw new Exception("Projeto não encontrado");
            }
            throw new Exception(ex.getMessage());
        }


        return branch;
    }

    public void deleteBranch(String url) throws Exception{
        log.info("deletando branch");
        Branch branch = new Branch();
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(url);
        } catch (Exception ex) {
            if (ex.getMessage().matches("404 Not Found")) {
                throw new Exception("Projeto não encontrado");
            }
            throw new Exception(ex.getMessage());
        }
    }
}
