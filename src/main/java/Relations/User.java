package Relations;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id",
    referencedColumnName = "id")
    private Passport passport;

    public User(String name, String surname, Passport passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
    }
}
