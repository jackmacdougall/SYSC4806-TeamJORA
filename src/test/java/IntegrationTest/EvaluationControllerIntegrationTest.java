package IntegrationTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import springboot.BootApplication;
import springboot.Controller.EvaluationController;
import springboot.Model.Item;
import springboot.Model.Rubric;
import springboot.Model.Student;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = BootApplication.class)
public class EvaluationControllerIntegrationTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private Item item;
    private Rubric rubric;
    private Student student;

    @Before
    public void setup() {
        this.item = new Item("Item 1", "Item description 1");
        this.rubric = new Rubric(this.item);
        this.student = new Student("Andrew");
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLoadEvaluationListPage() throws Exception {
        this.mockMvc.perform(get("/evaluation/"))
                .andExpect(status().isOk())
                .andExpect(view().name("Peer Assessment Tool | Evaluations"))
                .andExpect(model().attributeExists("evaluations"))
                .andReturn();
    }

    @Test
    public void testLoadAddEvaluationPage() throws Exception {
        this.mockMvc.perform(get("/rubric/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("Peer Assessment Tool | Add New Evaluation"))
                .andExpect(model().attributeExists("result"))
                .andExpect(model().attributeExists("students"))
                .andExpect(model().attributeExists("rubrics"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attributeExists("items"))
                .andReturn();
    }
}
