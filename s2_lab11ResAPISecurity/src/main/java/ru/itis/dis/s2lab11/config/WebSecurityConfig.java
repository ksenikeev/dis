package ru.itis.dis.s2lab11.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    @Qualifier("myUserDetailsServise")
    private UserDetailsService userDetailsService;

/*
    @Autowired
    @Qualifier("jwtAuthenticationFilter")
    private GenericFilterBean jwtAuthenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;
*/

    @Autowired
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        //auth.authenticationProvider(authenticationProvider);

    }

/*
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/restsignin");
    }
*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/merch").permitAll()
                .antMatchers("/newmerch").permitAll()
                //.antMatchers("/restsignin").permitAll()
                //.antMatchers("/").authenticated()
                //.antMatchers("/org").hasAnyAuthority("ADMIN")
                //.anyRequest().authenticated()
        ;

/*
        http.formLogin(*/
/*withDefaults()*//*
)
                .loginPage("/login")
                //.loginProcessingUrl("/myuserlogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll();
*/

        //http.addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class);

        //        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    }

}