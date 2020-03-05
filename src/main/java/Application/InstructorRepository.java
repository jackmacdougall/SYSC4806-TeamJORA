package Application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "instructor", path = "instructor")
public interface InstructorRepository extends CrudRepository<Instructor, Long>{
    List<Instructor> findByName(String name);
}
