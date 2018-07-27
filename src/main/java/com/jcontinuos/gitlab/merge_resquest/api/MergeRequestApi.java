package com.jcontinuos.gitlab.merge_resquest.api;

import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.merge_resquest.service.MergeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/gitlab")
public class MergeRequestApi {

    @Autowired
    private MergeRequestService service;

    @PostMapping(value = "/merge/develop")
    public void mergeBranchToDevelop(@RequestBody ParameterMerges params){
       service.mergeToDevelop(params);
    }
}
