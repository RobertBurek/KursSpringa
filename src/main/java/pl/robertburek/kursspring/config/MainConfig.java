package pl.robertburek.kursspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import pl.robertburek.kursspring.domain.repository.InDBKnightRepository;
import pl.robertburek.kursspring.domain.repository.InMemoryKnightRepository;
import pl.robertburek.kursspring.domain.repository.KnightRepository;

import javax.annotation.Resource;

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

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        //to jest rozwiązanie developerski a nie produkcyjne (generowanie w pamięci) zreszta nie działa
//        authenticationManagerBuilder.inMemoryAuthentication()
//                .withUser("user1").password("user1").roles("USER").and()
//                .withUser("Robert").password("Robert7").roles("ADMIN").and()
//                .withUser("InnyUser").password("InnyUser7").roles("USER");
        System.out.println("---------------ustawienie użytkowników nie działa !!!--------------------------------");
    }
}
