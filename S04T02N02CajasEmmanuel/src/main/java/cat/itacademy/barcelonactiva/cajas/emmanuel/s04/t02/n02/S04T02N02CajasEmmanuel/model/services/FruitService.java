package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.services;

import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n02.S04T02N02CajasEmmanuel.model.domain.Fruit;

import java.util.List;

public interface FruitService {

    public List<Fruit> getAllfruits();
    public Fruit addFruit(Fruit fruit);
    public Fruit updateFruit(Fruit fruit);
    public Fruit getFruitById(int id);
    public void deleteFruit(int id);
}
