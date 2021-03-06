package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.Model.Instructor;
import springboot.Service.PersonService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private final PersonService service;

    private InstructorController(PersonService service) {
        this.service = service;
    }

    @GetMapping(value = "/addInstructorPage")
    public String addInstructorPage(@ModelAttribute Instructor instructor, Model model) {
        model.addAttribute("person", new Instructor());
        return "addInstructorPage";
    }

    @PostMapping(value = "/add")
    public String addInstructor(@ModelAttribute Instructor instructor, Model model) {
        service.addPerson(instructor);
        model.addAttribute("person", service.getAllPersons());
        return "personListPage";
    }

}
