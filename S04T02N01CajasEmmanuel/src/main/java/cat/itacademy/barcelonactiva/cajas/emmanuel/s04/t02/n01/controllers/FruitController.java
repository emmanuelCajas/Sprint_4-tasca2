package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n01.model.repository.IFrutaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class FruitController {

    @Autowired
    private IFrutaJpaRepository fruitRepository;

    @GetMapping("/getAllFruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){

        try {
            List<Fruit> fruitList = new ArrayList<>();
            fruitRepository.findAll().forEach(fruitList::add);

            if(fruitList.isEmpty() ){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruitList, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getFruitById/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Integer id){
        Optional<Fruit> fruitObj= fruitRepository.findById(id);

        if(fruitObj.isPresent() ){
            return new ResponseEntity<>(fruitObj.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addFruit")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit){
        try {
            Fruit fruitObj = fruitRepository.save(fruit);
            return new ResponseEntity<>(fruitObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateFruit/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Integer id, @RequestBody Fruit fruit) {
        try {
            Optional<Fruit> fruitData = fruitRepository.findById(id);
            if (fruitData.isPresent()) {
                Fruit updatedBookData = fruitData.get();
                updatedBookData.setName(fruit.getName());
                updatedBookData.setKilosQuantity(fruit.getKilosQuantity());

                Fruit bookObj = fruitRepository.save(updatedBookData);
                return new ResponseEntity<>(bookObj, HttpStatus.CREATED);
            }

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteFruitById/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable Integer id) {
        try {
            fruitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
