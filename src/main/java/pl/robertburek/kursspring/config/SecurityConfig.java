package pl.robertburek.kursspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

/**
 * Created by Robert Burek
 */

//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Override
//    public void configure(HttpSecurity security) throws Exception {
//        security.authorizeRequests()
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/knights").hasAnyAuthority("USER", "ADMIN")
//                .antMatchers("/knight").hasAnyAuthority("ADMIN")
//                .anyRequest().authenticated()
//                .and()//.httpBasic(); //tutaj też działa formularz logowania
//                .formLogin()   //bez tego też jest formularz logowania
//                .defaultSuccessUrl("/knights");
//    }
//
//    @Autowired
//    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource).usersByUsernameQuery(
//        "SELECT username,password,enabled FROM PLAYER_INFORMATION WHERE username = ?")
//                .authoritiesByUsernameQuery("SELECT username,userrole FROM ROLE WHERE username = ?");
//    }
//}
