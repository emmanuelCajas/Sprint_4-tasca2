package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n01.model.repository;


import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrutaJpaRepository extends JpaRepository<Fruit,Integer> {

}
