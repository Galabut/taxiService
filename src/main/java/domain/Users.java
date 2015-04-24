package domain;

import javax.persistence.*;

/**
 * Created by Galabut on 14.04.2015.
 */
@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_USERS_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



