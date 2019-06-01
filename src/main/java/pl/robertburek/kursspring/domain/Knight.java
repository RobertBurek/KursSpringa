package pl.robertburek.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Robert Burek
 */

@Component
public class Knight {

//    @Value("Zbyszko")    takie wykorzystanie @Value jest niespotykane
    private String name = "Zbyszko";
//    @Value("35")    takie wykorzystanie @Value jest niespotykane
    private int age = 35;

    private Quest quest; //klasa podrzędna

    public Knight() {
    }


    //wstrzykiwanie poprzez konstruktor
//    public Knight(String name, int age, Quest quest) {
//        this.name = name;
//        this.age = age;
//        this.quest = quest;
//    }

    //wstrzykiwanie poprzez metodę
    @Autowired
    public void setQuest(Quest quest) {
        System.out.println("Ustawiam zadanie dla rycerza.");
        this.quest = quest;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + this.name + "(" + this.age + "). Ma za zadanie : " + this.quest;
    }
}
