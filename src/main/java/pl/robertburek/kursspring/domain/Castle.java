package pl.robertburek.kursspring.domain;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Robert Burek
 */

@Component  // spring bean
@PropertySource("classpath:castle.properties")
public class Castle {

    @Autowired
    Knight knight;

    @Value("${my.castle.name:EastCastle}")
    private String name;

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

    @Override
    public String toString() {
        return "Znajduje się tu zamek o nazwie " + this.name + ". Zamieszkuje go " + knight;
    }
}
