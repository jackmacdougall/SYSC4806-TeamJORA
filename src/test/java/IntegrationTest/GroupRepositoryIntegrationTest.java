package IntegrationTest;

import springboot.Model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.Model.GroupRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GroupRepository groupRepository;

    @Test
    public void whenFindByName_thenReturnGroup(){
        Group group = new Group("Test Group");
        entityManager.persist(group);
        entityManager.flush();

        Group found = groupRepository.findByName(group.getName());

        assertThat(found.getName())
                .isEqualTo(group.getName());
    }

}
