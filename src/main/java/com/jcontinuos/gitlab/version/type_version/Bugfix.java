package com.jcontinuos.gitlab.version.type_version;

import com.jcontinuos.gitlab.version.dto.Version;

public class Bugfix implements TypeVersion {
    @Override
    public String newVersion(Version current) {
        return null;
    }

    @Override
    public Version split(String currentVersion) {
        return null;
    }
}
