package com.sdl.elm.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sdl
 * @date 2020/4/8 3:32 下午
 * @description
 */
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {
    static String winpath;
    static String otherospath;
    static String profile;

    public String getWinpath() {
        return winpath;
    }

    public void setWinpath(String winpath) {
        this.winpath = winpath;
    }

    public String getOtherospath() {
        return otherospath;
    }

    public void setOtherospath(String otherospath) {
        this.otherospath = otherospath;
    }

    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public static String getPath(){
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            return winpath;
        }else {
            return otherospath;
        }
    }
}
