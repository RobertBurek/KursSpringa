package pl.robertburek.kursspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
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
}
