package IntegrationTest;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import springboot.BootApplication;
import springboot.Controller.GroupController;
import springboot.Controller.ItemController;
import springboot.Model.Group;
import springboot.Model.Item;
import springboot.Model.ItemRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = BootApplication.class)
public class ItemControllerIntegrationTest {

    @Autowired
    ItemController itemController;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private Item item = new Item("Criteria", "Description");

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLoadAddItemPage() throws Exception{
        this.mockMvc.perform(get("/item/addItemPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("addItemPage"))
                .andExpect(model().attributeExists("item"))
                .andReturn();
    }

    @Test
    public void testLoadItemListPage() throws Exception{
        this.mockMvc.perform(get("/item/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("itemListPage"))
                .andExpect(model().attributeExists("item"))
                .andReturn();
    }

    @Test
    public void testAddItem() throws Exception{
        assertNull(itemRepository.findByName(this.item.getName()));
        this.mockMvc.perform(post("/item/add").flashAttr("item", item));
        assertThat(this.item.getName()).isSameAs(itemRepository.findByName(item.getName()).getName());
        assertThat(this.item.getId()).isSameAs(itemRepository.findByName(item.getName()).getId());
    }
}