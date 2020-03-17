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
import springboot.Controller.InstructorController;
import springboot.Model.Instructor;
import springboot.Model.PersonRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = BootApplication.class)
public class InstructorControllerIntegrationTest {

    @Autowired
    InstructorController instructorController;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private Instructor instructor;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testLoadAddPersonPage() throws Exception {
        this.mockMvc.perform(get("/person/addInstructorPage"))
                .andExpect(status().isOk())
                .andExpect(view().name("addInstructorPage"))
                .andExpect(model().attributeExists("person"))
                .andReturn();
    }

    @Test
    public void testAddInstructor() throws Exception {
        assertNull(personRepository.findByName(this.instructor.getName()));
        this.mockMvc.perform(post("/instructor/add").flashAttr("person", instructor));

        assertThat(this.instructor.getName()).isSameAs(personRepository.findByName(instructor.getName()).getName());
        assertThat(this.instructor.getId()).isSameAs(personRepository.findByName(instructor.getName()).getId());
    }
}
