package com.jcontinuos.gitlab.realease.service;

import com.jcontinuos.gitlab.branchs.service.BranchService;
import com.jcontinuos.gitlab.merge_resquest.service.MergeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PipelineRealeaseService {

    @Autowired
    private MergeRequestService mergeRequestService;
    @Autowired
    private BranchService branchService;

    public void init(){

    }
}
