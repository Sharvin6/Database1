package com.example.pet_adoption_platform.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for security settings.
 */
@Configuration
public class SecurityConfig {

    //Configures security filters.
     //@param http The HttpSecurity object to configure security settings.
     //@return The configured SecurityFilterChain.
     //@throws Exception If an error occurs during configuration.
     
    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/", "/login", "/pets", "/breedDetails/**").permitAll() // Allow access to breedDetails
                    .requestMatchers("/pets/**", "/customers/**").authenticated()
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
            )
            .logout(logout ->
                logout
                    .logoutSuccessUrl("/")
                    .permitAll()
            );

        return http.build();
    }

    // Configures an in-memory user details manager with an admin user.
     //@return UserDetailsService bean.
     
    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("admin")
            .password(passwordEncoder().encode("password"))
            .roles("ADMIN")
            .build());
        return userDetailsManager;
    }

    //Provides a password encoder bean.
     // @return PasswordEncoder bean.
   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
