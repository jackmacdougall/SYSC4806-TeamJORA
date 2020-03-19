package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.Model.Instructor;
import springboot.Model.Student;
import springboot.Service.PersonService;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final PersonService service;

    private StudentController(PersonService service) {
        this.service = service;
    }

    @GetMapping(value = "/addStudentPage")
    public String addStudentPage(@ModelAttribute Student student, Model model) {
        model.addAttribute("person", new Student());
        return "addStudentPage";
    }

    @PostMapping(value = "/add")
    public String addInstructor(@ModelAttribute Student student, Model model) {
        service.addPerson(student);
        model.addAttribute("person", service.getAllPersons());
        return "personListPage";
    }
}
