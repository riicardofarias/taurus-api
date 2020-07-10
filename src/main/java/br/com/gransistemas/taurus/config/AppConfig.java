package br.com.gransistemas.taurus.config;

import br.com.gransistemas.taurus.intercetor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**");
    }
} 