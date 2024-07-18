package cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, String> {
}
