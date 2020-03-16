package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.Service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    private PersonController(PersonService service){
        this.service = service;
    }

    @GetMapping(value = "/all")
    public String itemListPage(Model model) {
        model.addAttribute("person", service.getAllPersons());
        return "personListPage";
    }
}
