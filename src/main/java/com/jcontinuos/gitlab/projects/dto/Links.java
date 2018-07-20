package com.jcontinuos.gitlab.projects.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links {
    private String self;
    private String issues;
    @JsonProperty(value = "merge_requests")
    private String mergeRequests;
    @JsonProperty(value = "repo_branches")
    private String repoBranches;
    private String labels;
    private String events;
    private String members;

    public String getSelf() {
        return self;
    }

    public String getIssues() {
        return issues;
    }

    public String getMergeRequests() {
        return mergeRequests;
    }

    public String getRepoBranches() {
        return repoBranches;
    }

    public String getLabels() {
        return labels;
    }

    public String getEvents() {
        return events;
    }

    public String getMembers() {
        return members;
    }
}