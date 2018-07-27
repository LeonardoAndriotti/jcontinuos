package com.jcontinuos.gitlab.merge_resquest.service;

import com.jcontinuos.gitlab.branchs.gateway.BranchGateway;
import com.jcontinuos.gitlab.branchs.service.BranchService;
import com.jcontinuos.gitlab.merge_resquest.dto.MergeRequest;
import com.jcontinuos.gitlab.merge_resquest.dto.ParameterMerges;
import com.jcontinuos.gitlab.merge_resquest.gateway.MergeRequestGateway;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class MergeRequestService {

    private static final Logger log = LoggerFactory.getLogger(MergeRequestService.class);

    @Autowired
    private MergeRequestGateway gateway;


    public void mergeBranchToDevelop(ParameterMerges params) {
        log.info("Mergeando as atividade na develop");
        for(String name :params.getBrandsName()){
            MergeRequest request = translate(params,name);
            try {
                gateway.createMergeRequest(request);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (JSONException e) {
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
    public void approvadMergesDevelop() {
        try {

        } catch (Exception ex) {
            //tratar os erros de aprovação de merge aqui
        }
    }
}
