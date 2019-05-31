package pl.robertburek.kursspring.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Robert Burek
 */

@Component  // spring bean
public class Castle {
    private String name = "East Watch";

    public Castle() {
    }

    @PostConstruct //metoda zostanie wykonana gdy spring bedzie tworzony
    //w momencie tworzenia kontenera, wszystkie metody tak oznaczone będą wykonane
    //nazwa metody nie ma znaczenia
    public void build() {
        System.out.println("Wybudowano zamek " + name);
    }

    @PreDestroy      //metoda zostanie wykonana gdy spring zostanie zamknięty
    //wszystkie metody tak oznaczone będą wykonane
    //nazwa metody  nie ma znaczenia
    public void tearDown() {
        System.out.println("Zaraz wyburzymy zamek " + name);
    }
}
