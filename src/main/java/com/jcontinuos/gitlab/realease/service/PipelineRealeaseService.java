package com.jcontinuos.gitlab.realease.service;

import com.jcontinuos.gitlab.branchs.service.BranchService;
import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.merge_resquest.service.MergeRequestService;
import com.jcontinuos.gitlab.realease.dto.Type;
import org.assertj.core.util.diff.Delta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipelineRealeaseService {

    @Autowired
    private MergeRequestService mergeRequestService;
    @Autowired
    private BranchService branchService;

    public void create(ParameterMerges params) {
      try{
          mergeRequestService.init(params);
      }catch (Exception ex){

      }
    }

    public void remove(ParameterMerges params) {
        //tirar release para produção
    }
}
