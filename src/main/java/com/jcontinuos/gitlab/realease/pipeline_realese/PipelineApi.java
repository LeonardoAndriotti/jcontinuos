package com.jcontinuos.gitlab.realease.pipeline_realese;

import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.merge_resquest.service.MergeRequestService;
import com.jcontinuos.gitlab.realease.service.PipelineRealeaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/gitlab")
public class PipelineApi {

    @Autowired
    private PipelineRealeaseService service;

    @PostMapping(value = "/create/release")
    public void createNewRealease(@RequestBody ParameterMerges params){
        //criar uma fila para executar um realese por fez.
        service.create(params);

    }
    @PostMapping(value = "/remove/release")
    public void removeRealease(@RequestBody ParameterMerges params){
        //criar uma fila para executar um realese por fez.
        service.remove(params);

    }

}
