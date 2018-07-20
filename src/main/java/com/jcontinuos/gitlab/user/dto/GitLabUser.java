package com.jcontinuos.gitlab.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitLabUser {

    private Long id;
    private String name;
    private String username;
    private String state;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("email")
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getState() {
        return state;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public String getEmail() {
        return email;
    }
}
