package IntegrationTest;

import ch.qos.logback.core.encoder.EchoEncoder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import springboot.Controller.RubricController;
import springboot.Model.Item;
import springboot.Model.Rubric;
import springboot.Model.RubricRepository;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = BootApplication.class)
public class RubricIntegrationTest {
    @Autowired
    RubricController rubricController;

    @Autowired
    RubricRepository rubricRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private Item item;
    private Rubric rubric;

    @Before
    public void setup() {
        this.item = new Item("Item 1", "Item description 1");
        this.rubric = new Rubric(this.item);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLoadRubricListPage() throws Exception {
        this.mockMvc.perform(get("/rubric/showall"))
                .andExpect(status().isOk())
                .andExpect(view().name("Peer Assessment Tool | Rubric List"))
                .andExpect(model().attributeExists("rubric"))
                .andReturn();
    }

    @Test
    public void testLoadAddRubricPage() throws Exception {
        this.mockMvc.perform(get("/rubric/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Peer Assessment Tool | New Rubric"))
                .andExpect(model().attributeExists("rubric"))
                .andReturn();
    }

//    @Test
//    public void testAddGroup() throws Exception {
//        assertNull(rubricRepository.findById(this.rubric.getId()));
//        this.mockMvc.perform(post("/rubric/").flashAttr("rubric", rubric));
//
//        assertThat(this.rubric.getId()).isSameAs(rubricRepository.findById(rubric.getId()));
//    }
}
