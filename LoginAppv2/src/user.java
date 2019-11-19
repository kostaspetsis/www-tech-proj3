

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class user implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    private String USERNAME;
    private String PASSWORD;
    

    // Constructors:
    public user() {
    }

    public user(String username, String password) {
        this.USERNAME = username;
        this.PASSWORD = password;
    }

    // String Representation:
    @Override
    public String toString() {
        return USERNAME + " (signed on! " + ")";
    }
} 