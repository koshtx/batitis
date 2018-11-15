/*package tutorial;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {
    private @Id @GeneratedValue Long id;
    private String name;
    private String password;
    private Boolean active;

    private User() {}

    public User(String name, String password, Boolean active) {
        this.name = name;
        this.password = password;
        this.active = active;
    }
}
*/