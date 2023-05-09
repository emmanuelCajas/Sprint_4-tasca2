package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.Controller;


import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.repository.IFrutaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {
    @Autowired
    private IFrutaJpaRepository fruitRepository;

    @GetMapping(value= "/getAllFruits")
    public List<Fruit> getTasks(){
        return fruitRepository.findAll();
    }

    @PostMapping(value="/addFruit")
    public String saveTask(@RequestBody Fruit fruit){
        fruitRepository.save(fruit);
        return "Saved task";
    }

    @PutMapping(value="/update/{id}")
    public String updateTask(@PathVariable Integer id, @RequestBody Fruit fruit){
        Fruit updateFruit = fruitRepository.findById(id).get();
        updateFruit.setName(fruit.getName());
        updateFruit.setKilosQuantity(fruit.getKilosQuantity());
        fruitRepository.save(updateFruit);
        return "Updated Fruits";
    }

    @DeleteMapping(value="delete/{id}")
    public String deleteTask(@PathVariable Integer id){
        Fruit deletedTask = fruitRepository.findById(id).get();
        fruitRepository.delete(deletedTask);
        return "Deleted Task";
    }

}
