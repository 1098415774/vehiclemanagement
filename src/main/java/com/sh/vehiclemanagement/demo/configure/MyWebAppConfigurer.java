package com.sh.vehiclemanagement.demo.configure;

import com.sh.vehiclemanagement.demo.interceptor.FormHandleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FormHandleInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
