package com.utilisateurs.dishapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Configuration
//public class CorsConfig {

    //@Bean
    //public CorsConfigurationSource corsConfigurationSource() {
        //CorsConfiguration corsConfig = new CorsConfiguration();
        //corsConfig.addAllowedOrigin("http://localhost:3000"); // Allow frontend origin
        //corsConfig.addAllowedMethod("GET"); // Allow specific HTTP methods
        //corsConfig.addAllowedMethod("POST");
        //corsConfig.addAllowedMethod("PUT");
        //corsConfig.addAllowedMethod("DELETE");
        //corsConfig.addAllowedHeader("*"); // Allow all headers
        //corsConfig.setAllowCredentials(true); // Allow credentials (cookies, tokens)

        //UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //source.registerCorsConfiguration("/**", corsConfig); // Apply CORS to all endpoints
      //  return source;
    //}

    //@Bean
    //public CorsFilter corsFilter() {
    //    return new CorsFilter(corsConfigurationSource());
  //  }
//}

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}


