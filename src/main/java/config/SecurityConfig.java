package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll()
                        .anyRequest().permitAll()
                )
                .headers(headers -> headers.disable()); // Disable security headers
        return http.build();
    }    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();        // Allow access from specific IP addresses and domains
        configuration.setAllowedOrigins(Arrays.asList(
            "http://localhost:3000",          // Local development with common React port
            "http://localhost:5173",          // Local development with Vite
            "http://localhost:5500",          // VS Code Live Server default port
            "http://127.0.0.1:3000",          // Alternative localhost
            "http://127.0.0.1:5500",          // VS Code Live Server on 127.0.0.1
            "http://10.251.52.216:3000",      // Your local WiFi IP address (React)
            "http://10.251.52.216:5173",      // Your local WiFi IP address (Vite)
            "http://10.251.52.216:5500",      // Your local WiFi IP with Live Server
            "http://200.229.7.9:3000",        // Your public IP with React port
            "http://200.229.7.9:5173",        // Your public IP with Vite port
            "http://200.229.7.9:5500"         // Your public IP with Live Server
        ));
        
        // Note: We're not using wildcard origins with credentials as it's not supported by browsers
        
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "X-Requested-With"));
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
