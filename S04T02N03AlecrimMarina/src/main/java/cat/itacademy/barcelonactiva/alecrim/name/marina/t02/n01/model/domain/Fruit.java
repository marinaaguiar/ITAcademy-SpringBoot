package cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "fruits")
public class Fruit {

    @Id
    private String id = UUID.randomUUID().toString();

    private String name;
    private int quantityKilos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKilos() {
        return quantityKilos;
    }

    public void setQuantityKilos(int quantityKilos) {
        this.quantityKilos = quantityKilos;
    }
}
