package cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.services;

import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.exceptions.ItemAlreadyExistsException;
import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.exceptions.ItemNotFoundException;
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

    public Fruit addFruit(Fruit fruit) throws ItemAlreadyExistsException {
        fruitRepository.findById(fruit.getId())
                .ifPresent(fruitIn -> {
                    try {
                        throw new ItemAlreadyExistsException(fruit.getName() + " already exists.");
                    } catch (ItemAlreadyExistsException e) {
                        throw new RuntimeException(e);
                    }
                });
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Fruit fruit) throws ItemNotFoundException {
        Fruit fruitToUpdate = fruitRepository.findById(fruit.getId())
                .orElseThrow(() -> new ItemNotFoundException("Fruit with id: " + fruit.getId() + " does not exist."));

        fruitToUpdate.setName(fruit.getName());
        fruitToUpdate.setQuantityKilos(fruit.getQuantityKilos());
        return fruitRepository.save(fruitToUpdate);
    }

    public void deleteFruit(String id) throws ItemNotFoundException {
        fruitRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ItemNotFoundException("Fruit with id: " + id + " not found."));
        fruitRepository.deleteById(id);
    }

    public Fruit getFruitByID(String id) throws ItemNotFoundException {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Fruit with id: " + id + " not found."));
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
