package pl.robertburek.kursspring.domain;

/**
 * Created by Robert Burek
 */
public class Knight {

    private String name;
    private int age;
    private Quest quest; //klasa podrzędna

    //wstrzykiwanie poprzez konstruktor
    public Knight(String name, int age, Quest quest) {
        this.name = name;
        this.age = age;
        this.quest = quest;
    }

    //wstrzykiwanie poprzez metodę
    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + this.name + " (" + this.age + "). Zadanie : " + this.quest;
    }
}
