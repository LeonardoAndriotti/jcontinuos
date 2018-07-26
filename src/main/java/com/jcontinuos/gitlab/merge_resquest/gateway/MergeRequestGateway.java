package com.jcontinuos.gitlab.merge_resquest.gateway;

import com.jcontinuos.gitlab.http.RequestExecutor;
import com.jcontinuos.gitlab.merge_resquest.dto.MergeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.List;

import static java.lang.String.format;

public class MergeRequestGateway {

    private static final Logger log = LoggerFactory.getLogger(MergeRequestGateway.class);

    private RequestExecutor executor = new RequestExecutor();

    private MergeResquestExtract convertJson = new MergeResquestExtract();


    public List<MergeRequest> getMergeByUser() throws URISyntaxException {
        log.info(format("Buscando Merge Request, no projeto = %s, feito pelo usuário = %s","Teste","teste"));
        ResponseEntity<String> result = this.executor.get("http://gitlab.anymarket.intranet/api/v4/projects/89/merge_requests?author_id=13&private_token=UyKcJCnX9TNsqKBYMAFx", null, String.class);
        return convertJson.extract(result);
    }

    public static void main(String[] args) throws Exception {
        new MergeRequestGateway().getMergeByUser();
    }
}
