package pl.robertburek.kursspring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by Robert Burek
 */

@Entity
//@Table(name="Zadania")
public class Quest {

    //mapowanie bezpośrednio na pola
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    @Column(name="Opis")
    private String description;

    private int reward = 100;

    //    @Transient  //pole nie będzie zapisywane do bazy
    protected int lenghtInSeconds = 15;

    private boolean started = false;
    private boolean completed = false;
    protected LocalDateTime startDate;

    public Quest() {
    }

    public Quest(int id, String tresc) {
        this.id = id;
        this.description = tresc;
    }

    public Quest(String description) {
        this.description=description;
    }

    public Quest(String description, int reward) {
        this.description = description;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLenght() {
        return lenghtInSeconds;
    }

    public void setLenght(int lenght) {
        this.lenghtInSeconds = lenght;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startDate = LocalDateTime.now();
        }
        this.started = started;
    }

    public boolean isCompleted() {
        if (this.completed) {
            return this.completed;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lenghtInSeconds);
            boolean isAfter = now.isAfter(questEndDate);
            if (isAfter) {
                this.completed = true;
            }
            return isAfter;
        }
    }

    //    ustawiamy tutaj jak chcemy używać geteróe i seterów do ustawiania danych w tabeli
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
