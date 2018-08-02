package com.jcontinuos.gitlab.merge_resquest.gateway;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcontinuos.gitlab.http.DateSerializer;
import com.jcontinuos.gitlab.merge_resquest.dto.MergeRequest;
import org.assertj.core.util.Preconditions;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MergeResquestExtract {

    private static final Gson GSON = new GsonBuilder().setDateFormat(DateSerializer.FORMAT).create();

    public List<MergeRequest> extract(ResponseEntity<String> result) {
        Preconditions.checkNotNull(result, "O result deve ser informado para realizar a extração.");
        return Arrays.asList(GSON.fromJson(result.getBody(), MergeRequest[].class));
    }

    public MergeRequest extractSimple(ResponseEntity<String> result) {
        Preconditions.checkNotNull(result, "O result deve ser informado para realizar a extração.");

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        return gson.fromJson(result.getBody(),  MergeRequest.class);

    }

}
