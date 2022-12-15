package Relations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tShirtName;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="user_clothes",
    joinColumns = @JoinColumn(name = "clothes_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> user;

    public Clothes(String tShirtName, List<User> user) {
        this.tShirtName = tShirtName;
        this.user = user;
    }

    public Clothes(String tShirtName) {
        this.tShirtName = tShirtName;
    }
}
