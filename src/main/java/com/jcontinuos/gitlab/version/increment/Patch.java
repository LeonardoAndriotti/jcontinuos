package com.jcontinuos.gitlab.version.increment;

public class Patch implements VersionControl {

    private static final String PATCH = "patch";

    @Override
    public String increment(Long numberVersion) {
        return String.valueOf(numberVersion + 1);
    }

    @Override
    public String version() {
        return PATCH;
    }
}
