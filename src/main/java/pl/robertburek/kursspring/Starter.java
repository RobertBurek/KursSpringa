package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.robertburek.kursspring.domain.Castle;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.Quest;

/**
 * Created by Robert Burek
 */

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);

    }
}
