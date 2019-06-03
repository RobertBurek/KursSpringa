package pl.robertburek.kursspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.Quest;

/**
 * Created by Robert Burek
 */
@Configuration
public class MainConfig {

    @Autowired
    Quest quest;

    @Bean(name="robert")
    @Primary  //ustawiony jako domyślny
    public Knight robert(){
        Knight robert = new Knight("Robert",45);
        robert.setQuest(quest);
        return robert;
    }

    @Bean(name = "grzegorz")
    public Knight createKnight(){
        Knight grzegorz = new Knight("Grzegorz",44);
        grzegorz.setQuest(quest);
        return grzegorz;
    }

}
