package com.bolgov.config;

import com.bolgov.EasyPasswordEncoder;
import com.bolgov.service.UserService;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
        //@EnableGlobalMethodSecurity(prePostEnabled = true)
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
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userService);
//        provider.setPasswordEncoder(new EasyPasswordEncoder());
//        return provider;
//    }

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
                                        .and().formLogin().permitAll();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                )
                ;

        //.and()
//                .formLogin().loginPage("/login")
//                .defaultSuccessUrl("/user/votes/winner").permitAll()
        //.and()
        //.logout().permitAll().logoutSuccessUrl("/login");
        return httpSecurity.build();
    }

//    @Bean
//    public Filter configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .anyRequest()
//                .requestMatchers("/h2", "/h2/**")
//                .requestMatchers("resources/**");
//        return web.build();
//    }

}
