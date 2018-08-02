package com.jcontinuos.gitlab.version.type_version;

import com.jcontinuos.gitlab.version.dto.Version;

public interface TypeVersion {
    String newVersion(Version current);

    Version split(String currentVersion);
}
