package com.jcontinuos.gitlab.merge_resquest.gateway;

import com.jcontinuos.gitlab.http.RequestExecutor;
import com.jcontinuos.gitlab.merge_resquest.dto.MergeRequest;
import com.jcontinuos.gitlab.user.service.GenerateUrl;
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
    private static final String ACCEPT_MAERGE = "/projects/%s/merge_requests/%s/merge";
    private static final String MERGE_REQUEST = "/projects/%s/merge_requests";

    @Autowired
    private RequestExecutor executor;
    @Autowired
    private MergeResquestExtract convertJson;
    @Autowired
    private GenerateUrl generateUrl;

    public List<MergeRequest> getMergeByUser(MergeRequest body) throws URISyntaxException {
        log.info(format("Buscando Merge Request, no projeto = %s, feito pelo usuário = %s", "Teste", "teste"));

        String url = generateUrl.url(String.format(MERGE_REQUEST,body.getProjectId()));

        Map<String, String> params = new HashMap<>();
        params.put("private_token", "TOKEN");
        params.put("author_id", "USER");

        ResponseEntity<String> result = this.executor.get(url, params, String.class);
        return convertJson.extract(result);
    }

    public MergeRequest createMergeRequest(MergeRequest body) throws URISyntaxException, JSONException {
        String url = generateUrl.url(String.format(MERGE_REQUEST,body.getProjectId()));

        //pegar usuário logado
        JSONObject json = new JSONObject();
        json.put("id", body.getId());
        json.put("source_branch", body.getSourceBranch());
        json.put("target_branch", body.getTargetBranch());
        json.put("title", body.getTitle());

        Map<String, String> params = new HashMap<>();
        params.put("private_token", "yeBLGjYzsGy6QyssYYaB");

        ResponseEntity<String> result = this.executor.post(url, json.toString(), params, String.class);
        return convertJson.extractSimple(result);
    }

    public MergeRequest acceptMergeRequest(Long idProject, Long iid) throws URISyntaxException, JSONException {
        log.info(format("Aceitando merge request, no projeto = %s, Id do merge = %s", "Teste", "teste"));

        String url = generateUrl.url(String.format(ACCEPT_MAERGE,idProject,iid));

        Map<String, String> params = new HashMap<>();
        params.put("private_token", "yeBLGjYzsGy6QyssYYaB");

        ResponseEntity<String> result = this.executor.put(url, null, params, String.class);
        return convertJson.extractSimple(result);

    }

    //http://gitlab.anymarket.intranet/api/v4/projects/89/merge_requests/2/merge?private_token=yeBLGjYzsGy6QyssYYaB  PUT ACCEPT MERGE
    //POST /projects/:id/merge_requests

}
