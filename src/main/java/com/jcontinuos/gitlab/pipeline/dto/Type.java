package com.jcontinuos.gitlab.pipeline.dto;

public enum Type {
    CREATE("CREATE"),
    REMOVE("REMOVE");

    private String type;

    Type(String type) {
        this.type = type;
    }
}
