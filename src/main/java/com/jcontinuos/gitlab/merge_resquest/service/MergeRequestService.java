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
        List<MergeRequest> merges = mergeBranchToDevelop(params);
        approvadMergesDevelop(merges);
    }
    private List<MergeRequest> mergeBranchToDevelop(ParameterMerges params) throws Exception{
        log.info("Mergeando as atividade na develop");
        List<MergeRequest> merges = new ArrayList<>();
        for(String name : params.getBranchName()){
            MergeRequest request = translate(params,name);
            try {
                merges.add(gateway.createMergeRequest(request));
                //adicionar como passo feito branch mergeada.
            } catch (Exception e) {
                if(e.getMessage().equals("401 Unauthorized")){
                    throw new Exception("Você não tem autorização para fazer o merge das tarefas.");
                }else if(e.getMessage().equals("409 Conflict")){
                    //branch já foi mergeada para develop
                    throw new Exception("branch já foi mergeada para develop.");
                }
            }
        }
        return merges;
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

    private void approvadMergesDevelop(List<MergeRequest> merges) {
        try {

        } catch (Exception ex) {
            //tratar os erros de aprovação de merge aqui
        }
    }
}
