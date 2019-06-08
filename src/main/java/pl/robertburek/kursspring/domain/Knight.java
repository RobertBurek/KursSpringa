package pl.robertburek.kursspring.domain;

import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

/**
 * Created by Robert Burek
 */

@Entity
public class Knight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "Imie rycerza musi mieć od 2 do 40 znaków")
    private String name;

    @NotNull
    @Range(min = 18, max = 60, message = "Wiek rycerza musi być od 18 do 60 znaków")
    private int age;

    private int level;

//    @Embedded   // dane związane z encją w której się znajduje
    @OneToOne  //relacja jedendo jednego
    private Quest quest;

    public Knight() {
        this.level =1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.level = 1;
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

    public void setQuest(Quest quest) {
        if(quest!=null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public Quest getQuest() {
        return quest;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", imie='" + name + '\'' +
                "(" + age + ")" +
                ", level=" + level +
                ", quest=" + quest;
    }
}
