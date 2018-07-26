package com.jcontinuos.gitlab.merge_resquest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    private Long id;
    private String name;
    private String username;
    private String state;
    @JsonProperty(value = "avatar_url")
    private String avatarUrl;
    @JsonProperty(value = "web_url")
    private String webUrl;

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
}
