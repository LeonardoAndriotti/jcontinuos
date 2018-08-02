package com.jcontinuos.gitlab.version.increment;

public interface VersionControl {

    String increment(Long numberVersion);
    String version();

}
