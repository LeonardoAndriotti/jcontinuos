package com.jcontinuos.gitlab.merge_resquest.service;

import com.jcontinuos.gitlab.merge_resquest.dto.MergeRequest;
import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.merge_resquest.gateway.MergeRequestGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MergeRequestService {

    private static final Logger log = LoggerFactory.getLogger(MergeRequestService.class);

    @Autowired
    private MergeRequestGateway gateway;


    public void init(ParameterMerges params) throws Exception {
        mergeBranchToDevelop(params);
        approvadMergesDevelop();
    }
    private void mergeBranchToDevelop(ParameterMerges params) throws Exception{
        log.info("Mergeando as atividade na develop");
        List<MergeRequest> merges = new ArrayList<>();
        for(String name :params.getBrandsName()){
            MergeRequest request = translate(params,name);
            try {
                merges.add(gateway.createMergeRequest(request));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private MergeRequest translate(ParameterMerges params,String origin){
        MergeRequest request = new MergeRequest();
        request.setId(new Long(13));//buscar id do usuário logado
        request.setProjectId(params.getProjectId());
        request.setTargetBranch("develop");
        request.setSourceBranch(origin);
        request.setTitle(params.getTitle());
        return request;
    }

    private void approvadMergesDevelop() {
        try {

        } catch (Exception ex) {
            //tratar os erros de aprovação de merge aqui
        }
    }
}
