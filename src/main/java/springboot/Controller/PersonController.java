package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.Model.Person;
import springboot.Model.User;
import springboot.Service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    private PersonController(PersonService service){
        this.service = service;
    }

    @GetMapping(value = "/addPersonPage")
    public String addPersonPage() {
        return "addPersonPage";
    }

    @GetMapping(value = "/all")
    public String personListPage(Model model) {
        model.addAttribute("person", service.getAllPersons());
        return "personListPage";
    }

    @PostMapping(value = "/selectUser")
    public String setPersonAsUser (String name, Model model){
        User.person = service.getPerson(name);
        model.addAttribute("person", service.getAllPersons());
        System.out.println("user is " + User.person.getName());
        return "personListPage";
    }
}
