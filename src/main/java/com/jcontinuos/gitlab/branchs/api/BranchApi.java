package com.jcontinuos.gitlab.branchs.api;

import com.jcontinuos.gitlab.branchs.dto.Branch;
import com.jcontinuos.gitlab.branchs.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/gitlab")
public class BranchApi {

    @Autowired
    private BranchService service;

    @GetMapping(value = "/project/{id}/branchs")
    public List<Branch> findBranchsByProjectId(@PathVariable("id") Long id) throws Exception {
        return service.findBranchByProjectsId(id);
    }

    @GetMapping(value = "/project/{id}/branchs/{name}")
    public Branch findBranchByName(@PathVariable("id") Long id, @PathVariable("name") String name) throws Exception {
        return service.findBranchByName(id, name);
    }

    @PostMapping(value = "/project/{id}/branchs/{name}")
    public Branch createBranch(@PathVariable("id") Long id, @PathVariable("name") String name) throws Exception {
        return service.createBranch(id, name);
    }

    @DeleteMapping(value = "/project/{id}/branchs/{name}")
    public void deleteBranch(@PathVariable("id") Long id, @PathVariable("name") String name) throws Exception {
        service.deleteBranch(id,name);
    }
}
