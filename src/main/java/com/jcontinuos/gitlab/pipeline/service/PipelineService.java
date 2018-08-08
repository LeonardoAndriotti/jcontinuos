package com.jcontinuos.gitlab.pipeline.service;

import com.jcontinuos.gitlab.branchs.service.BranchService;
import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.merge_resquest.service.MergeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipelineService {

    @Autowired
    private MergeRequestService mergeRequestService;
    @Autowired
    private BranchService branchService;

    public void create(ParameterMerges params) throws Exception{
        try {
            mergeRequestService.init(params);
            //criar branch partir da develop
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public void remove(ParameterMerges params) {
        //tirar release para produção
    }
}
