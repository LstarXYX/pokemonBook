package pokement.lstar.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pokement.lstar.common.AuthInterceptor;

/**
 * @author L.star
 * @date 2022/2/27 11:09
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new AuthInterceptor());
        registration.addPathPatterns("/**");
        registration.excludePathPatterns(
                "/login","/admin/**","/**/*.html","/**/*.js", "/**/*.css");
    }
}
