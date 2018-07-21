package com.jcontinuos.gitlab.projects.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Permissions {
    @JsonProperty(value = "project_access")
    private ProjectAccess projectAccess;
    @JsonProperty(value = "group_access")
    private GroupAccess groupAccess;

    public ProjectAccess getProjectAccess() {
        return projectAccess;
    }

    public GroupAccess getGroupAccess() {
        return groupAccess;
    }
}
