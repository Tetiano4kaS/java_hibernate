package Relations;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Fuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "car_fuel",
    joinColumns = @JoinColumn(name="fuel_id"),
            inverseJoinColumns = @JoinColumn(name="car_id")
    )
    private List<Car> cars;

    public Fuel(String name, List<Car> cars) {
        this.name = name;
        this.cars = cars;
    }
}
