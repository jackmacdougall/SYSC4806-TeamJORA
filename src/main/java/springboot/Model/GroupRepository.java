package springboot.Model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends CrudRepository<Group, Integer> {
    Group findByName(@Param("name") String name);
}
