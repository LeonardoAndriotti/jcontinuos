package com.jcontinuos.gitlab.projects.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupAccess {
    @JsonProperty(value = "access_level")
    private Long accessLevel;
    @JsonProperty(value = "notification_level")
    private Long notificationLevel;

    public Long getAccessLevel() {
        return accessLevel;
    }

    public Long getNotificationLevel() {
        return notificationLevel;
    }
}
