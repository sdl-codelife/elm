package com.sdl.elm.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sdl
 * @date 2020/4/8 2:16 下午
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 映射文件
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(ProjectConfig.getProfile()).addResourceLocations("file:"+ProjectConfig.getPath());
    }
}
