package pl.robertburek.kursspring.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by Robert Burek
 */

public class Knight {

    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "Imie rycerza musi mieć od 2 do 40 znaków")
    private String name;

    @NotNull
    @Range(min = 18, max = 60, message = "Wiek rycerza musi być od 18 do 60 znaków")
    private int age;

    private int level;

    private Quest quest;

    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public String toString() {
//        return " imie " + this.name + "(" + this.age + "). Ma za zadanie : " + this.quest;
//    }


    @Override
    public String toString() {
        return "id=" + id +
                ", imie='" + name + '\'' +
                "(" + age + ")" +
                ", level=" + level +
                ", quest=" + quest;
    }

    public void setQuest(Quest quest) {
//        System.out.println("Ustawiam zadanie dla rycerza.");
        this.quest = quest;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
