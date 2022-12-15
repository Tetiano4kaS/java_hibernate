package Relations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vinKode;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name="car_fuel",
            joinColumns = @JoinColumn(name="car_id"),
            inverseJoinColumns = @JoinColumn(name="fuel_id"))
    private Fuel fuel;

    public Car(String vinKode) {
        this.vinKode = vinKode;
    }
}
