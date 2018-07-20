package com.jcontinuos.gitlab.projects.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Namespace {
    private Long id;
    private String name;
    private String path;
    private String kind;
    @JsonProperty(value = "full_path")
    private String fullPath;
    @JsonProperty(value = "parent_id")
    private String parentId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getKind() {
        return kind;
    }

    public String getFullPath() {
        return fullPath;
    }

    public String getParentId() {
        return parentId;
    }
}