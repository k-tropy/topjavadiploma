package com.bolgov.config;

import com.bolgov.EasyPasswordEncoder;
import com.bolgov.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new EasyPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserService userService) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());

        List<AuthenticationProvider> providers = List.of(authProvider);

        return new ProviderManager(providers);
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        {
                            try {
                                authorizeHttpRequests
                                        .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
                                        .requestMatchers(new AntPathRequestMatcher("/user/**")).hasRole("USER")
                                        .requestMatchers(new AntPathRequestMatcher("/h2/**")).permitAll()
                                        .requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
                                        .anyRequest().authenticated()
                                        .and()
                                        .formLogin().defaultSuccessUrl("/user/votes/winner", true).permitAll();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                );

        return httpSecurity.build();
    }

}
