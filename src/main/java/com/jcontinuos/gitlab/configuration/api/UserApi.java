package com.jcontinuos.gitlab.configuration.api;

import com.jcontinuos.gitlab.configuration.dto.UserConfig;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserApi {

    @GetMapping(value = "/user")
    public UserConfig getUser(){
        return null;
    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserConfig user){
        //criar o post
    }

    @PutMapping(value = "/user")
    public void updateUser(@RequestBody UserConfig user){
        //criar o put
    }

}
