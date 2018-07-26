package com.jcontinuos.gitlab.versions;

import com.jcontinuos.gitlab.versions.dto.Version;
import com.jcontinuos.gitlab.versions.dto.Versioning;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IncrementVersion {


    private static final String MAJOR = "major";
    private static final String MINOR = "minor";
    private static final String PATCH = "patch";

    public String version (String currentVersion, Versioning versioning){
         Version current  = split(currentVersion);

         if(Versioning.MAJOR.equals(versioning)){
             String major  = increment(new Long(current.getVersions().get(MAJOR)),Versioning.MAJOR);
             current.getVersions().put(MAJOR,major);
         }else if(Versioning.MINOR.equals(versioning)){
             String minor = increment(new Long(current.getVersions().get(MINOR)),Versioning.MINOR);
             current.getVersions().put(MINOR,minor);
         }else if (Versioning.PATCH.equals(versioning)){
             String patch = increment(new Long(current.getVersions().get(PATCH)),Versioning.PATCH);
             current.getVersions().put(PATCH,patch);
         }else if(Versioning.BUILDER_NUMBER.equals(versioning)){
             String builderNumber  = increment(new Long(current.getBuilderNumber()),Versioning.BUILDER_NUMBER);
             current.setBuilderNumber(builderNumber);
         }

         return newVersion(current);
    }

    private String increment(Long numberVersion, Versioning versioning){
        if(Versioning.MINOR.equals(versioning) && numberVersion < 10){
            Long number = numberVersion + 1;
            return "0" + number;
        }
        return String.valueOf(numberVersion + 1);
    }

    private String newVersion(Version current) {
        return current.getVersions().get(MAJOR).concat(".")
                .concat(current.getVersions().get(MINOR)).concat(".")
                .concat(current.getVersions().get(PATCH)).concat("-")
                .concat(current.getQualifier())
                .concat(current.getBuilderNumber());
    }

    private Version split (String currentVersion){
        String [] split1 = currentVersion.split("-");
        String [] split2 = split1[0].split("\\u002e");
        String qualifier = split1[1].replaceAll("[^a-zA-Z]+", "");
        String builderNumber = split1[1].replaceAll("[^0-9]+", "");

        Map<String,String> map = new HashMap<>();
        map.put("major",split2[0]);
        map.put("minor",split2[1]);
        map.put("patch",split2[2]);

        return new Version(qualifier,builderNumber,map);
    }
}
