package pl.robertburek.kursspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.robertburek.kursspring.domain.repository.InDBKnightRepository;
import pl.robertburek.kursspring.domain.repository.InMemoryKnightRepository;
import pl.robertburek.kursspring.domain.repository.KnightRepository;

/**
 * Created by Robert Burek
 */
@Configuration
public class MainConfig {

    @Bean(name = "inMemoryKnightRepository")
//    @Primary
    @Profile("dev")
    public KnightRepository createInMemoryRepo() {
        KnightRepository repo = new InMemoryKnightRepository();
        return repo;
    }

    @Bean(name = "inDBKnightRepository")
    @Profile("prod")
    public KnightRepository createInDBRepo() {
        KnightRepository repo = new InDBKnightRepository();
        return repo;
    }

//    @Autowired
//    public void securityUsers(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password("{noop}user1").roles("USER").and()
//                .withUser("Robert").password("{noop}Robert").roles("ADMIN").and()
//                .withUser("InnyUser").password("{noop}InnyUser").roles("USER");
//    }
}
