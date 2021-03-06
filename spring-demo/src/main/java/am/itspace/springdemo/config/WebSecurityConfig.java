package am.itspace.springdemo.config;

import am.itspace.springdemo.security.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailServiceImpl userDetailService ;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

          http.csrf().disable()
                  .formLogin()
                  .loginPage("/loginPage")
                  .loginProcessingUrl("/perform_login")
                  .defaultSuccessUrl("/successLogin")
                  .and()
                  .logout().logoutSuccessUrl("/")
                  .and()
                  .authorizeRequests()
                  .antMatchers("/").permitAll()
                  .antMatchers(HttpMethod.GET,"/editBook").hasAnyAuthority("USER","ADMIN")
                  .antMatchers("/deleteBook").hasAnyAuthority("ADMIN");


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailService)
            .passwordEncoder(passwordEncoder);
     /*  auth.inMemoryAuthentication()
               .withUser("poxos")
               .password(encoder().encode("poxos"))
               .roles("USER").and()
               .withUser("petros")
               .password(encoder().encode("petros"))
               .roles("ADMIN");*/
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }



}

























