package pl.robertburek.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Robert Burek
 */

@Component
public class Castle {


    Knight knight;

    @Value("${my.castle.name:Default Castle}")
    private String name;

    @Autowired   //tu jest konstruktor zatem @Qualifier(value="") stawiamy przy obiekcie Knight
//    public Castle(@Qualifier(value = "robert") Knight knight) {
//        this.knight = knight;
//    }
    //mamy ustawiony @Primary knight na "robert"
    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }

    public void build() {
        System.out.println("Wybudowano zamek " + name);
    }

    public void tearDown() {
        System.out.println("Zaraz wyburzymy zamek " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Znajduje się tu zamek o nazwie " + this.name + ". Zamieszkuje go " + knight;
    }
}
