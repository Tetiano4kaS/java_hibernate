package relations;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;
    private String number;
@OneToOne(cascade = CascadeType.ALL, mappedBy = "passport")
    private User user;

    public Passport(String series, String number) {
        this.series = series;
        this.number = number;
    }
}
