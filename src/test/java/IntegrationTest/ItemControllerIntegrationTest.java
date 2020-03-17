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

import static org.hamcrest.Matchers.containsString;
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
    private WebApplicationContext wac;

    private MockMvc mockMvc;

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
    public void testLoadGroupListPage() throws Exception{
        this.mockMvc.perform(get("/item/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("itemListPage"))
                .andExpect(model().attributeExists("item"))
                .andReturn();
    }

}