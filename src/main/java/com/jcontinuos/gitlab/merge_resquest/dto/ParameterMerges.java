package com.jcontinuos.gitlab.merge_resquest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParameterMerges {
    @JsonProperty(value="title", required=true)
    private String title;
    @JsonProperty(value="branch_name", required=true)
    private List<String> branchName;
    @JsonProperty(value="project_id", required=true)
    private Long projectId;
    @JsonProperty(value="target_branch", required=true)
    private List<String> targetBranch;

    public List<String> getTargetBranch() {
        return targetBranch;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getBranchName() {
        return new ArrayList<>(branchName);
    }

    public Long getProjectId() {
        return projectId;
    }

}
