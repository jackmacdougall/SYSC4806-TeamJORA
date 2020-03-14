package IntegrationTest;

import org.springframework.boot.test.context.SpringBootTest;
import springboot.Model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.Model.ItemRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void whenFindByName_thenReturnItem(){
        Item item = new Item("Test Item","Test description");
        entityManager.persist(item);
        entityManager.flush();

        Item found = itemRepository.findByName(item.getName());

        assertThat(found.getName())
                .isEqualTo(item.getName());
    }

}
