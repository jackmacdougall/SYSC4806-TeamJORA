package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "persons", path = "persons")
public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByName(@Param("name") String name);
    Person findByIsUser(@Param("isUser") Boolean isUser);
}