package com.jcontinuos.gitlab.version.increment;

public class Minor implements VersionControl {

    private static final String MINOR = "minor";

    @Override
    public String increment(Long numberVersion) {
        if(numberVersion < 10){
            Long number = numberVersion + 1;
            return "0" + number;
        }
        return String.valueOf(numberVersion + 1);
    }

    @Override
    public String version() {
        return MINOR;
    }
}
