package com.java.blogposts.configs;

import com.java.blogposts.configs.filter.JWTTokenGeneratorGenerator;
import com.java.blogposts.configs.filter.JWTTokenValidatorFilter;
import com.java.blogposts.configs.filter.LogBeforeFilter;
import com.java.blogposts.constants.RoleConstant;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String API = "api";

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{


        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                        .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                        config.setAllowedOrigins(Collections.singletonList("*"));
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setExposedHeaders(Arrays.asList("Authorization"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and().csrf().disable()
                .addFilterBefore(new JWTTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGeneratorGenerator(), BasicAuthenticationFilter.class)
                .addFilterBefore(new LogBeforeFilter(), JWTTokenValidatorFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(API +"/get-all-users").hasAnyRole(RoleConstant.ORGANIZATION,RoleConstant.USER)
                .requestMatchers(API +"/get-post/*").hasRole(RoleConstant.USER)
                .requestMatchers(API +"/get-all-posts").hasAnyRole(RoleConstant.ORGANIZATION)
                .requestMatchers(API +"/get-all-category").hasRole(RoleConstant.ORGANIZATION)
                .requestMatchers(API +"/get/post/category/*").hasRole(RoleConstant.USER)
                .requestMatchers(API +"/get-user/*").hasRole(RoleConstant.USER)
                .requestMatchers(API +"/user").authenticated()
                .and().httpBasic();

//                csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and().authorizeHttpRequests().anyRequest().authenticated();


//        httpSecurity.authorizeHttpRequests().anyRequest().permitAll().and().csrf().disable();
        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
