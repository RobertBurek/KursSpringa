package pl.robertburek.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Robert Burek
 */

@Component
public class Tournament {

    @Autowired
    @Qualifier(value ="grzegorz") // ze wzgklędu że tu jest pole
    Knight knight;

    public Tournament() {
    }

    public void duel() {
        knight.setAge(knight.getAge() + 2);
    }

    public String toString() {
        return "W turnieju bierze udział " + this.knight;
    }

    public String getKnight() {
        return knight.getName() + "(" + knight.getAge() + ")";
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }
}
