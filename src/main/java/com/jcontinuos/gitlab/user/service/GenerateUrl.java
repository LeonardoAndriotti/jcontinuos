package com.jcontinuos.gitlab.user.service;

import org.springframework.stereotype.Component;

@Component
public class GenerateUrl {

    private static final String BASE = "http://gitlab.anymarket.intranet/api/v4";

    public String url(String path){
        return BASE + path;
    }
}
