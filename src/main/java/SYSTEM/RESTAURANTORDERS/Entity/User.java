package SYSTEM.RESTAURANTORDERS.Entity;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@Entity
@Table(name = "users")

public class User {
    @javax.persistence.Id
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
