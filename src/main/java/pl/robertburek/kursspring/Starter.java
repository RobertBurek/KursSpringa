package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.robertburek.component.TestComponent;
import pl.robertburek.kursspring.domain.Castle;

/**
 * Created by Robert Burek
 */

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    TestComponent test;

    @Autowired
    Castle castle;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);

    }
}
