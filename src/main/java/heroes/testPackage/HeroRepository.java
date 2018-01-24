package heroes.testPackage;

import heroes.Hero;
import org.springframework.data.repository.CrudRepository;


import java.util.Collection;

public interface HeroRepository extends CrudRepository<Hero, Long> {
    Collection<Hero> findAll();
}
