package com.jcontinuos.gitlab.version.increment;

public class Major implements VersionControl {

    private static final String MAJOR = "major";

    @Override
    public String increment(Long numberVersion) {
        return String.valueOf(numberVersion + 1);
    }

    @Override
    public String version() {
        return MAJOR;
    }
}
