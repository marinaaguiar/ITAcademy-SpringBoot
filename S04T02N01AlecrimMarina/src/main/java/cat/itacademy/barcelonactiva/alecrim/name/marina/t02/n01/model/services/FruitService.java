package cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.services;

import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Optional<Fruit> updateFruit(Fruit fruit) {
        if (fruitRepository.existsById(fruit.getId())) {
            return Optional.of(fruitRepository.save(fruit));
        }
        return Optional.empty();
    }

    public boolean deleteFruit(int id) {
        if (fruitRepository.existsById(id)) {
            fruitRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Fruit> getFruitByID(int id) {
        return fruitRepository.findById(id);
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
