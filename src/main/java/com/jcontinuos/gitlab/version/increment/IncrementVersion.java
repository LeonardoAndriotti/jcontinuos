package com.jcontinuos.gitlab.version.increment;

import com.jcontinuos.gitlab.version.dto.Version;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncrementVersion {

    private static final String MAJOR = "major";
    private static final String MINOR = "minor";
    private static final String PATCH = "patch";

   /* public String version(String currentVersion, VersionControl version) {
        Version current = split(currentVersion);

        String newVersion = version.increment(new Long(current.getVersions().get(version.version())));
        current.getVersions().put(version.version(), newVersion);

        return newVersion(current);
    }*/
/*
    private String newVersion(Version current) {
        return current.getVersions().get(MAJOR).concat(".")
                .concat(current.getVersions().get(MINOR)).concat(".")
                .concat(current.getVersions().get(PATCH)).concat("-")
                .concat(current.getQualifier())
                .concat(current.getBuilderNumber());
    }*/

   /* private Version split(String currentVersion) {
        String[] split1 = currentVersion.split("-");
        String[] split2 = split1[0].split("\\u002e");
        String qualifier = split1[1].replaceAll("[^a-zA-Z]+", "");
        String builderNumber = split1[1].replaceAll("[^0-9]+", "");

        Map<String, String> map = new HashMap<>();
        map.put("major", split2[0]);
        map.put("minor", split2[1]);
        map.put("patch", split2[2]);

        return new Version(qualifier, builderNumber, map);
    }*/


}
