package com.SpringSecurity.demosecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class Config  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("saikat")
                .password("$2a$10$dsfk5z4w2tlv3UlwwJ0qyOBVeOR7/X47Rd98vOF3Xzwjsvlb1G0cC")
                .authorities("FACULTY")
                .and()
                .withUser("sumit")
                .password("$2a$10$aiXnCzhdjXvsFRq4zqAQPuV6d13HhIZ75fTvjRiQHhjdLfNXW00z2")
                 .authorities("STUDENT");

    }
    //There are two options
    //1. Either provide STUDENT and FACULTY authority while authenticating
    //2. OR We can check for multiple authorities for every API call


    //Always keep the most restricted API at the beginning followed by the least restricted ones
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/student/**").hasAnyAuthority("STUDENT","FACULTY")
                .antMatchers(HttpMethod.POST,"/student/**").hasAuthority("STUDENT")
                .antMatchers("/faculty/**").hasAuthority("FACULTY")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();

    }
    //ApplicationContext.getBeanDefinitionNames()
    //@Bean
    //public PasswordEncoder getEncoder(){
      //  return NoOpPasswordEncoder.getInstance();
    //}
    @Bean
    public BCryptPasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }

}
//JSESSIONID=649A03426ACAB973ABD9CBC088EFEA0C
//1503DF7813CBC517DCCB685204D406EE
