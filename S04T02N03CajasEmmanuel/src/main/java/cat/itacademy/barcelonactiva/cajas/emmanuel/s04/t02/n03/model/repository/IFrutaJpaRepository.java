package cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n03.model.repository;
import cat.itacademy.barcelonactiva.cajas.emmanuel.s04.t02.n03.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFrutaJpaRepository extends MongoRepository<Fruit,Integer> {

}
