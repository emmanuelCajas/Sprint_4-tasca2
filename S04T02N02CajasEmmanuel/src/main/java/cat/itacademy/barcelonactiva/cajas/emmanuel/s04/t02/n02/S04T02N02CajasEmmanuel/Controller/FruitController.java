package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.controller;
import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.services.FruitImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fruit")
public class FruitController {

    @Autowired
    private FruitImpl fruitImpl;

    @GetMapping
    @RequestMapping(value = "getAllFruits",method = RequestMethod.GET)
    public ResponseEntity<?> getAllFruits(){
        List<Fruit> fruitList=this.fruitImpl.getAllfruits();
        return ResponseEntity.ok(fruitList);
    }
    @PutMapping
    @RequestMapping(value = "addFruit",method = RequestMethod.POST)
    public ResponseEntity<?> addFruit(@RequestBody Fruit fruit){
        Fruit addFruit=this.fruitImpl.addFruit(fruit);
        return ResponseEntity.status(HttpStatus.CREATED).body(addFruit);
    }
    @PutMapping
    @RequestMapping(value = "updateFruit",method = RequestMethod.PUT)
    public ResponseEntity<?> updateFruit(@RequestBody Fruit fruit){
        Fruit update=this.fruitImpl.updateFruit(fruit);
        return ResponseEntity.status(HttpStatus.CREATED).body(update);
    }
    @GetMapping
    @RequestMapping(value = "getFruitById/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getFruitById(@PathVariable int id){
        Fruit persona=this.fruitImpl.getFruitById(id);
        return ResponseEntity.ok(persona);
    }
    @DeleteMapping
    @RequestMapping(value = "deleteFruitById/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFruit(@PathVariable int id){
        this.fruitImpl.deleteFruit(id);
        return ResponseEntity.ok().build();
    }
}
