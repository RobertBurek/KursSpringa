package pl.robertburek.kursspring.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Robert Burek
 */

@Component
@Entity
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PlayerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int gold = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
