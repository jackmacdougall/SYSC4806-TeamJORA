package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "instructors", path = "instructors")
public interface InstructorRepository extends CrudRepository <Instructor, Integer> {
    Instructor findByName(@Param("name") String name);
}
