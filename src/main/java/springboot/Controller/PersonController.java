package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addPersonPage(Model model) {
        return "addPersonPage";
    }

    @GetMapping(value = "/all")
    public String personListPage(@RequestParam(defaultValue = "-1") Integer user, Model model) {
        model.addAttribute("person", service.getAllPersons());
        model.addAttribute("currentUser", service.getUser());
        return "personListPage";
    }

    @PostMapping(value = "/selectUser")
    public String setPersonAsUser (@RequestParam Integer user, Model model){
        service.setUser(user);
        //model.addAttribute("person", service.getAllPersons());
        //model.addAttribute("currentUser", service.getUser());
        return "jorahome";
    }

}
