package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "students", path = "students")
public interface StudentRepository extends CrudRepository<Student, Long>{
   // List<Model.Student> findByName(String name);
   // List<Model.Student> findAll();
   // Model.Student findById(long id);
}