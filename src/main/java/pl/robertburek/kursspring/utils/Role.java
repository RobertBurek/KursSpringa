package pl.robertburek.kursspring.utils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Robert Burek
 */

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username; //userName==USER_NAME; username==USERNAME;

    private String userrole;

    public Role() {
    }

    public Role(String username, String userrole) {
        this.username = username;
        this.userrole = userrole;
    }
}
