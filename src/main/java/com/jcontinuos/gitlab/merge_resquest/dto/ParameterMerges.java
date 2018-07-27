package com.jcontinuos.gitlab.merge_resquest.dto;

import java.util.ArrayList;
import java.util.List;

public class ParameterMerges {

    private String title;

    private List<String> brandsName;

    private Long projectId;

    private String targetBrand;

    public String getTitle() {
        return title;
    }

    public List<String> getBrandsName() {
        return new ArrayList<>(brandsName);
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getTargetBrand() {
        return targetBrand;
    }
}
