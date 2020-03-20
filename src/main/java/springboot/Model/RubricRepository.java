package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rubric", path = "rubric")
public interface RubricRepository extends CrudRepository<Rubric, Integer> {
    Rubric findByName(@Param("item") String id);

    List<Rubric> findByItem(@Param("item") Item item);
}
