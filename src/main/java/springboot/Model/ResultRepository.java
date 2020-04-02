package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "results", path = "results")
public interface ResultRepository extends CrudRepository<Result, Integer> {
    List<Result> findByStudent(Student student);

    List<Result> findByRubric(Rubric rubric);
}
