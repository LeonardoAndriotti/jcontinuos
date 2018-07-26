package com.jcontinuos.gitlab.versions.dto;

public enum Versioning {
    MAJOR("MAJOR VERSION"),
    MINOR("MINOR VERSION"),
    PATCH("PATCH VERSION"),
    QUALIFIER("RELEASE"),
    BUILDER_NUMBER("BUILDER NUMBER");

    private final String value;

    Versioning(String version) {
        this.value = version;
    }
}

