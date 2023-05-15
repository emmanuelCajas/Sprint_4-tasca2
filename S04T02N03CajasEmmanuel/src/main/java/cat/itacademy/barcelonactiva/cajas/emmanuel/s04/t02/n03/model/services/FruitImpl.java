package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n03.model.repository.IFrutaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitImpl implements FruitService{

    @Autowired
    private IFrutaJpaRepository iFrutaJpaRepository;


    @Override
    public List<Fruit> getAllfruits() {
        return (List<Fruit>) this.iFrutaJpaRepository.findAll();
    }

    @Override
    public Fruit addFruit(Fruit fruit) {
        fruit.setName(fruit.getName());
        return this.iFrutaJpaRepository.save(fruit);
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        return this.iFrutaJpaRepository.save(fruit);
    }

    @Override
    public Fruit getFruitById(int id) {
        return this.iFrutaJpaRepository.findById(id).get();
    }

    @Override
    public void deleteFruit(int id) {
        this.iFrutaJpaRepository.deleteById(id);
    }
}
