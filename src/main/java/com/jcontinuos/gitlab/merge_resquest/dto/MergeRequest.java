package com.jcontinuos.gitlab.merge_resquest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MergeRequest {

    private Long id;
    private Long iid;
    @JsonProperty(value = "project_id")
    private Long projectId;
    private String title;
    private String description;
    private String state;
    @JsonProperty(value = "created_at")
    private String created_at;
    @JsonProperty(value = "updated_at")
    private String updatedAt;
    @JsonProperty(value = "target_branch")
    private String targetBranch;
    @JsonProperty(value = "source_branch")
    private String sourceBranch;
    private Author author;
    @JsonProperty(value = "source_project_id")
    private Long sourceProjectId;
    @JsonProperty(value = "target_project_id")
    private Long targetProjectId;
    @JsonProperty(value = "merge_when_pipeline_succeeds")
    private Boolean mergeWhenPipelineSucceeds;
    @JsonProperty(value = "merge_status")
    private String mergeStatus;
    private String sha;
    @JsonProperty(value = "merge_commit_sha")
    private String mergeCommitSha;
    @JsonProperty(value = "web_url")
    private String webUrl;


    public MergeRequest() {
    }

    public MergeRequest(Long id, Long projectId, String title, String targetBranch, String sourceBranch) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.targetBranch = targetBranch;
        this.sourceBranch = sourceBranch;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTargetBranch(String targetBranch) {
        this.targetBranch = targetBranch;
    }

    public void setSourceBranch(String sourceBranch) {
        this.sourceBranch = sourceBranch;
    }

    public Long getId() {
        return id;
    }

    public Long getIid() {
        return iid;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getState() {
        return state;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getTargetBranch() {
        return targetBranch;
    }

    public String getSourceBranch() {
        return sourceBranch;
    }

    public Author getAuthor() {
        return author;
    }

    public Long getSourceProjectId() {
        return sourceProjectId;
    }

    public Long getTargetProjectId() {
        return targetProjectId;
    }

    public Boolean getMergeWhenPipelineSucceeds() {
        return mergeWhenPipelineSucceeds;
    }

    public String getMergeStatus() {
        return mergeStatus;
    }

    public String getSha() {
        return sha;
    }

    public String getMergeCommitSha() {
        return mergeCommitSha;
    }

    public String getWebUrl() {
        return webUrl;
    }
}
