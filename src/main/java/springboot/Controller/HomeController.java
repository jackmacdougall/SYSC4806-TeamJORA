package springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.Model.*;
import springboot.Service.PersonService;

@Controller
public class HomeController {

    private final PersonService personService;

    private HomeController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping(value = "/")
    public String jorahome(Model model) {
        model.addAttribute("user", -1);
        return "jorahome";
    }

}
