package com.example.springbootspringmvcexamples;

import com.example.springbootspringmvcexamples.example06.interceptor.interceptor.AdminInterceptor06;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// mvc配置，重写方法
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    // 将拦截器注入
    @Autowired
    private AdminInterceptor06 adminInterceptor06;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截、通过规则
        registry.addInterceptor(adminInterceptor06)
                .addPathPatterns("/api/example06/admin/**");
    }

    // //Servlet级别，比拦截器更早
    // //是否允许携带cookies信息
    // @Bean
    // public CorsFilter corsFilter() {
    //     CorsConfiguration config = new CorsConfiguration();
    //     // 允许的来源
    //     config.addAllowedOrigin("*");
    //     // 允许的方法
    //     config.addAllowedMethod("*");
    //     // 允许的请求头
    //     config.addAllowedHeader("*");
    //     // 允许传递cookies对象
    //     config.setAllowCredentials(true);
    //     UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
    //     configurationSource.registerCorsConfiguration("/api/**", config);
    //     return new CorsFilter(configurationSource);
    // }
}
