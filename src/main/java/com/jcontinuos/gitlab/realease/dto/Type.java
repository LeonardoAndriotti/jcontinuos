package com.jcontinuos.gitlab.realease.dto;

public enum Type {
    CREATE("CREATE"),
    REMOVE("REMOVE");

    private String type;

    Type(String type) {
        this.type = type;
    }
}
