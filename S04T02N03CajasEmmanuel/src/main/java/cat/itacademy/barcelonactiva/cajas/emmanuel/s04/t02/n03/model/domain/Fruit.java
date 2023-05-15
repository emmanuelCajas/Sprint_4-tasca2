package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n03.model.domain;

//import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

//@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection = "fruits")
public class Fruit {

    @Id
    private int id;
    private String name;
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
