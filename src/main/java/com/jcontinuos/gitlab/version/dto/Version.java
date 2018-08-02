package com.jcontinuos.gitlab.version.dto;

import java.util.Map;

public class Version {

    private String qualifier;
    private String builderNumber;
    private Map<String,String> versions;

    public Version(String qualifier, String builderNumber, Map<String, String> versions) {
        this.qualifier = qualifier;
        this.builderNumber = builderNumber;
        this.versions = versions;
    }


    public String getQualifier() {
        return qualifier;
    }

    public String getBuilderNumber() {
        return builderNumber;
    }

    public Map<String, String> getVersions() {
        return versions;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public void setBuilderNumber(String builderNumber) {
        this.builderNumber = builderNumber;
    }

    public void setVersions(Map<String, String> versions) {
        this.versions = versions;
    }
}
