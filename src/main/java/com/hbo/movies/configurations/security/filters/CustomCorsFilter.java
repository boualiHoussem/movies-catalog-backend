package com.hbo.movies.configurations.security.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author Houssem BOUALI
 * date: 24/12/2021
 */
@Component
public class CustomCorsFilter {

    private final CorsFilter configuredFilter;

    public CustomCorsFilter() {
        this.configuredFilter = getCorsFilter();
    }

    public CorsFilter getConfiguredFilter() {
        return this.configuredFilter;
    }

    private CorsFilter getCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));

        source.registerCorsConfiguration("/**", configuration);

        return new CorsFilter(source);
    }
}
