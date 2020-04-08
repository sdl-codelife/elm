package com.sdl.elm;

import com.sdl.elm.config.ProjectConfig;
import com.sdl.elm.config.ServerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ElmApplication.class)
class ElmApplicationTests {
    @Autowired
    ServerConfig serverConfig;

    ProjectConfig ProjectConfig;
    @Test
    void contextLoads() {
        System.out.println(serverConfig.getUrl());
    }
    //localhost:8787/profile/lolijump-20200408041222456.gif
    @Test
    void test(){
        String url = "/Users/sdl/upload/avatar/lolijump-20200408041222456.gif";
        String path = "/Users/sdl/upload/";
        String profile = "/profile/**";
        int index = path.length();
        String a = profile.substring(0,profile.length()-2);
        System.out.println(a+url.substring(index));
//        System.out.println(new ProjectConfig.getPath());
    }

}
