package pl.robertburek.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Robert Burek
 */

public class Knight {

    private String name = "Wołodejowski";
    private int age = 31;
    private Quest quest;

    public Knight() {
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }
}
