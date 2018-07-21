package com.jcontinuos.gitlab.branchs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Commit {
    private String id;
    @JsonProperty(value = "short_id")
    private String shortId;
    private String title;
    @JsonProperty(value = "created_at")
    private String createAt;

    @JsonProperty(value = "parent_ids")
    private List<String> parentIds;
    private String message;
    @JsonProperty(value = "author_email")
    private String authorName;
    @JsonProperty(value = "authored_date")
    private String authoredDate;
    @JsonProperty(value = "committer_name")
    private String committerName;
    @JsonProperty(value = "committer_email")
    private String committerEmail;
    @JsonProperty(value = "committed_date")
    private String committedDate;

    public Commit() {
    }

    public String getId() {
        return id;
    }

    public String getShortId() {
        return shortId;
    }

    public String getTitle() {
        return title;
    }

    public String getCreateAt() {
        return createAt;
    }

    public List<String> getParentIds() {
        return parentIds;
    }

    public String getMessage() {
        return message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthoredDate() {
        return authoredDate;
    }

    public String getCommitterName() {
        return committerName;
    }

    public String getCommitterEmail() {
        return committerEmail;
    }

    public String getCommittedDate() {
        return committedDate;
    }
}
