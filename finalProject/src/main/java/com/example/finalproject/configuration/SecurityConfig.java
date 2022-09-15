package com.example.finalproject.configuration;
import com.example.finalproject.service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // User
                .antMatchers("/api/v1/student/register").permitAll()
                .antMatchers("/api/v1/student/login").permitAll()
                .antMatchers("/api/v1/student").permitAll()
                .antMatchers("/api/v1/student/update/{id}").permitAll()
                .antMatchers("/api/v1/student/delete/{id}").hasAuthority("Admin")


                //Admin
                .antMatchers("/api/v1/admin").hasAuthority("Admin")
                .antMatchers("/api/v1/admin/login").hasAuthority("Admin")


                //Comment
                .antMatchers("/api/v1/rating").permitAll()
                .antMatchers("/api/v1/rating/{id}").hasAuthority("Admin")



                // Professors
                .antMatchers("/api/v1/professors").permitAll()


                // University
//                .antMatchers("/api/v1/university").permitAll()



                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and()
                .httpBasic();
    }
}
