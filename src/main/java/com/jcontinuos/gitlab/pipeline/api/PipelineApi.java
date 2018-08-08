package com.jcontinuos.gitlab.pipeline.api;

import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.pipeline.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.assertj.core.util.Preconditions.checkArgument;
import static org.assertj.core.util.Strings.isNullOrEmpty;

@RestController
@RequestMapping(value = "api/gitlab")
public class PipelineApi {

    @Autowired
    private PipelineService service;

    @PostMapping(value = "/create/release")
    public void create(@RequestBody ParameterMerges params) throws Exception{
        checkParameterMerges(params);
        //criar uma fila para executar um realese por fez.
        service.create(params);

    }
    @PostMapping(value = "/remove/release")
    public void remove(@RequestBody ParameterMerges params){
        checkParameterMerges(params);
        //criar uma fila para executar um realese por fez.
        service.remove(params);
    }

    private void checkParameterMerges(ParameterMerges params) {
        checkArgument(params.getTargetBranch().size() > 0, "O Campo Target Brand é obrigatório.");
        checkArgument(!isNullOrEmpty(params.getTitle()), "O Campo Title é obrigatório.");
        checkArgument(!(Objects.isNull(params.getProjectId())), "O Campo Project Id é obrigatório.");
        checkArgument(!(params.getBranchName().size() <=0), "É obrigatório informar o nome da(s) branch(s) a ser mergeada.");

    }

}
