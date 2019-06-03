package pl.robertburek.kursspring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Robert Burek
 */

@Component
public class Tournament {

    @Autowired
    List<Knight> knights;
//    Map<String, Knight> knights;

    public Tournament() {
    }

//    public void duel() {
//        knight.setAge(knight.getAge() + 2);
//    }

    public String toString() {
        return "W turnieju bierą udział " + knights.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    public String getKnight() {
//        return knight.getName() + "(" + knight.getAge() + ")";
        return knights.stream().map(Object::toString).collect(Collectors.joining(","));
    }

    public void setKnight(List<Knight> knights) {
        this.knights = knights;
    }

//    public void setKnight(Map<String, Knight> knights) {
//        this.knights = knights;
//    }
}
