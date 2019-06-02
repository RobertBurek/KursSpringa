package pl.robertburek.kursspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by Robert Burek
 */

@Configuration
@Import(MainConfig.class)
public class CastleConfig {

    // nie wszystko da się przenieść
    //klasy zależne nie widzą się  w różnych klasach @Configuration
}
