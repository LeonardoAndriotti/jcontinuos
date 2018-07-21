package com.jcontinuos.gitlab.branchs.dto;

public class Branch {

    private String name;
    private Commit commit;
    private Boolean merged;

    public String getName() {
        return name;
    }

    public Commit getCommit() {
        return commit;
    }

    public Boolean getMerged() {
        return merged;
    }
}
