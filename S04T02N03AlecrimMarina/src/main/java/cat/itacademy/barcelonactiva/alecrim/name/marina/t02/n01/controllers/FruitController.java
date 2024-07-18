package cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.controllers;

import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.alecrim.name.marina.t02.n01.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        try {
            Fruit savedFruit = fruitService.addFruit(fruit);
            return new ResponseEntity<>(savedFruit, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        try {
            fruitService.updateFruit(fruit);
            return new ResponseEntity<>(fruit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable String id) {
        try {
            fruitService.deleteFruit(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable String id) {
        try {
            Fruit fruit = fruitService.getFruitByID(id);
            return new ResponseEntity<>(fruit, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            List<Fruit> fruits = fruitService.getAllFruits();
            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
