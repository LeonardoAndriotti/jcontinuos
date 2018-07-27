package com.jcontinuos.gitlab.merge_resquest.gateway;

import com.jcontinuos.gitlab.http.RequestExecutor;
import com.jcontinuos.gitlab.merge_resquest.dto.MergeRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

@Component
public class MergeRequestGateway {

    private static final Logger log = LoggerFactory.getLogger(MergeRequestGateway.class);
    private static final String PROJECT = "/projects/";
    private static final String MERGE_REQUEST ="/merge_requests";

    @Autowired
    private RequestExecutor executor;
    @Autowired
    private MergeResquestExtract convertJson;


    public List<MergeRequest> getMergeByUser() throws URISyntaxException {
        log.info(format("Buscando Merge Request, no projeto = %s, feito pelo usuário = %s", "Teste", "teste"));
        ResponseEntity<String> result = this.executor.get("http://gitlab.anymarket.intranet/api/v4/projects/89/merge_requests?author_id=13&private_token=TOKEN", null, String.class);
        return convertJson.extract(result);
    }

    public List<MergeRequest> createMergeRequest(MergeRequest body) throws URISyntaxException, JSONException {
        //pegar usuário logado
        JSONObject json = new JSONObject();
        json.put("id",body.getId());
        json.put("source_branch",body.getSourceBranch());
        json.put("target_branch",body.getTargetBranch());
        json.put("title",body.getTitle());

        Map<String,String> params = new HashMap<>();
        params.put("private_token","TOKEN");
        ResponseEntity<String> result = this.executor.post(generateUrl(body.getProjectId()),json,null,String.class);
        return convertJson.extract(result);
    }

    //POST /projects/:id/merge_requests
    private String generateUrl(Long projectId){
        String base = "http://gitlab.anymarket.intranet/api/v4"; //Buscar do banco depois
        return base + PROJECT + projectId + MERGE_REQUEST;
    }

}
