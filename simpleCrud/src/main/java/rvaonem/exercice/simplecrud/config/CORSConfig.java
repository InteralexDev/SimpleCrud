package rvaonem.exercice.simplecrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static rvaonem.exercice.simplecrud.config.ApplicationConfig.FRONTEND_ACP;

/**
 * This class is used to allow access to the controller methods from frontend
 * for POST and GET requests by configuring the CORS default config for the
 * specific FRONTEND access point.
 */
@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(FRONTEND_ACP);
            }
        };
    }

}
