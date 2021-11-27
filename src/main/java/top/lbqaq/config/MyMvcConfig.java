package top.lbqaq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author luoboQAQ
 * @Date 2021/11/14
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("auth/sign-in");
        registry.addViewController("/index.html").setViewName("auth/sign-in");
        registry.addViewController("/login").setViewName("auth/sign-in");
        registry.addViewController("/sign-in").setViewName("auth/sign-in");
        registry.addViewController("/sign-up").setViewName("auth/sign-up");
        registry.addViewController("/main.html").setViewName("welcome");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index.html", "/login", "/sign-in",
                        "/sign-up", "/auth/**", "/css/**", "/js/**",
                        "/image/**", "/picture/**");
    }
}
