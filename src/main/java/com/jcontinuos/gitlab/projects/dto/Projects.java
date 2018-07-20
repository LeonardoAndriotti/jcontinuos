package com.jcontinuos.gitlab.projects.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Projects {
    private Long id;
    private String description;
    private String name;
    @JsonProperty(value = "name_with_namespace")
    private String nameWithNamespace;
    private String path;
    @JsonProperty(value = "path_with_namespace")
    private String pathWithNamespace;
    @JsonProperty(value = "default_branch")
    private String defaultBranch;
    @JsonProperty(value = "ssh_url_to_repo")
    private String sshUrlToRepo;
    @JsonProperty(value = "http_url_to_repo")
    private String httpUrlToRepo;
    @JsonProperty(value = "web_url")
    private String webUrl;
    @JsonProperty(value = "avatar_url")
    private String avatarUrl;
    @JsonProperty(value = "start_count")
    private Long startCount;
    @JsonProperty(value = "forks_count")
    private Long forksCount;
    @JsonProperty(value = "_links")
    private Links links;
    @JsonProperty(value = "last_activity_at")
    private String lastActivityAt;
    private String visibility;
    private Namespace namespace;
    private Permissions permissions;


    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getNameWithNamespace() {
        return nameWithNamespace;
    }

    public String getPath() {
        return path;
    }

    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public String getSshUrlToRepo() {
        return sshUrlToRepo;
    }

    public String getHttpUrlToRepo() {
        return httpUrlToRepo;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Long getStartCount() {
        return startCount;
    }

    public Long getForksCount() {
        return forksCount;
    }

    public Links getLinks() {
        return links;
    }

    public String getLastActivityAt() {
        return lastActivityAt;
    }

    public String getVisibility() {
        return visibility;
    }

    public Namespace getNamespace() {
        return namespace;
    }

    public Permissions getPermissions() {
        return permissions;
    }
}
