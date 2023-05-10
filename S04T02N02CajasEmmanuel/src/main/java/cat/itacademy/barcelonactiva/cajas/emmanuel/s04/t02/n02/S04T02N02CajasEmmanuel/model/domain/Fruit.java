package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.domain;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "kilosQuantity")
    private int kilosQuantity;

    public Fruit() {
    }

    public Fruit(int id, String name, int kilosQuantity) {
        this.id = id;
        this.name = name;
        this.kilosQuantity = kilosQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKilosQuantity() {
        return kilosQuantity;
    }

    public void setKilosQuantity(int kilosQuantity) {
        this.kilosQuantity = kilosQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruit fruit)) return false;
        return id == fruit.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kilosQuantity=" + kilosQuantity +
                '}';
    }
}
