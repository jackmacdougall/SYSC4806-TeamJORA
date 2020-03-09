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
import springboot.Model.Group;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = BootApplication.class)
public class GroupControllerIntegrationTest {

    @Autowired
    GroupController customerController;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLoadAddGroupPage() throws Exception{
        this.mockMvc.perform(get("/group/addGroupPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("addGroupPage"))
                .andExpect(model().attributeExists("newGroup"))
                .andReturn();
    }

    @Test
    public void testLoadGroupListPage() throws Exception{
        this.mockMvc.perform(get("/group/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("groupListPage"))
                .andExpect(model().attributeExists("groups"))
                .andReturn();
    }

}
