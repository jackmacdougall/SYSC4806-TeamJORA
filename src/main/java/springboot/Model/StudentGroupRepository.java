package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "studentGroups", path = "studentGroups")
public interface StudentGroupRepository extends CrudRepository<StudentGroup, Long> {

}
