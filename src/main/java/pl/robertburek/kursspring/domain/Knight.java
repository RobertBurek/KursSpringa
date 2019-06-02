package pl.robertburek.kursspring.domain;

/**
 * Created by Robert Burek
 */

public class Knight {

    private String name;
    private int age;
    private Quest quest;

    public Knight() {
    }

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
