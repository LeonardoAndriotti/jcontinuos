package com.jcontinuos.gitlab.version.type_version;

import com.jcontinuos.gitlab.version.dto.Version;

import java.util.HashMap;
import java.util.Map;

public class Realese  implements TypeVersion {

    private static final String MAJOR = "major";
    private static final String MINOR = "minor";
    private static final String PATCH = "patch";

    @Override
    public String newVersion(Version current) {
        return current.getVersions().get(MAJOR).concat(".")
                .concat(current.getVersions().get(MINOR)).concat(".")
                .concat(current.getVersions().get(PATCH)).concat("-")
                .concat(current.getQualifier())
                .concat(current.getBuilderNumber());
    }

    @Override
    public Version split(String currentVersion) {
        String[] split1 = currentVersion.split("-");
        String[] split2 = split1[0].split("\\u002e");
        String qualifier = split1[1].replaceAll("[^a-zA-Z]+", "");
        String builderNumber = split1[1].replaceAll("[^0-9]+", "");

        Map<String, String> map = new HashMap<>();
        map.put("major", split2[0]);
        map.put("minor", split2[1]);
        map.put("patch", split2[2]);

        return new Version(qualifier, builderNumber, map);
    }
}
