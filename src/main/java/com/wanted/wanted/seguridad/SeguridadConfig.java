package com.wanted.wanted.seguridad;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true) // ahora prePostEnabled está a true por defecto
@EnableWebSecurity
@Configuration
public class SeguridadConfig {

        
         @Bean
        public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
         }

         @Bean
      public InMemoryUserDetailsManager userDetailsService() {
               UserDetails user = User.builder()
                               .username("user")
                              .password(passwordEncoder().encode("user"))
                             .roles("USER")                        .build();
              UserDetails admin = User.builder()
                              .username("admin")
                             .password(passwordEncoder().encode("admin"))
                             .roles("USER", "ADMIN")
                                .build();
               return new InMemoryUserDetailsManager(user, admin);} 

               
        @Bean
        public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {

                /* Esto es nuevo */
                http
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(AntPathRequestMatcher.antMatcher("/inicio/**"),
                                                                AntPathRequestMatcher.antMatcher("/webjars/**"),
                                                                AntPathRequestMatcher.antMatcher("/css/**"),
                                                                AntPathRequestMatcher.antMatcher("/imagen/**"),
                                                                AntPathRequestMatcher.antMatcher("/DragonBall/**"),
                                                                AntPathRequestMatcher.antMatcher("/Naruto/**"),
                                                                AntPathRequestMatcher.antMatcher("/OnePiece/**"),
                                                                AntPathRequestMatcher.antMatcher("/caracteristicas/**"),
                                                                AntPathRequestMatcher.antMatcher("/pagoEnca/**"),
                                                                AntPathRequestMatcher.antMatcher("/encabezado/**"),
                                                                AntPathRequestMatcher.antMatcher("/faqs/**"),
                                                                AntPathRequestMatcher.antMatcher("/registrarse/**"),
                                                                PathRequest.toH2Console())
                                                .permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/inicioSesion/login")
                                                .permitAll())
                                .logout(out -> out
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/inicio").permitAll());

                // Para que funcione la consola del h2
                http.csrf(csrf -> csrf.ignoringRequestMatchers(
                                AntPathRequestMatcher.antMatcher("/"),
                                AntPathRequestMatcher.antMatcher("/webjars/**"),
                                AntPathRequestMatcher.antMatcher("/css/**"),
                                PathRequest.toH2Console()));

                // Para que funcione la consola del h2
                http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));

                return http.build();

        }
}
