package pl.robertburek.kursspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import pl.robertburek.kursspring.Starter;
import pl.robertburek.kursspring.domain.Castle;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.Quest;

/**
 * Created by Robert Burek
 */
@Configuration
//@ImportResource("classpath:config/castle-config.xml")
@PropertySource("classpath:castle.properties") //potrzebne do parametrów nazwy zamku
public class MainConfig {

    @Bean
    public Quest createQuest() {
        return new Quest();
    }

    @Bean
    public Knight knight() {
        Knight knight = new Knight("Gniewko", 25);
        knight.setQuest(createQuest());
        return knight;
    }

    //    albo tak albo jak niżej poprzez parametr metody
    @Value("${my.castle.name:Default Castle}")
    String name;

    @Bean(name = "zamek", initMethod = "build", destroyMethod = "tearDown")
    @Value("${my.castle.name:Default Castle}")
    public Castle castle(String name) {
        Castle castle = new Castle(knight());
        castle.setName(name);
        return castle;
    }

    @Bean
    public Starter starter() {
        Starter starter = new Starter();
        starter.setCastle(castle(name));
        return starter;
    }
}
