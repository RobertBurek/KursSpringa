package pl.robertburek.kursspring.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by Robert Burek
 */
@Configuration
public class MainConfig {

    // w klasie konfiguracyjnej też dodajemy adnotację @Scope("prototype")
    // natomias w xml dodjamy do taga bean atrybut scope="prototype"

//    @Bean
//    @Scope("prototype")
//    public Knight knight(){
//        Knight knight = new Knight("Robert",45);
//        knight.setQuest(quest);
//        return knight;
//    }

}
