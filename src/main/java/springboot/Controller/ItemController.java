package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.Model.*;
import springboot.Service.ItemService;
import springboot.Service.PersonService;
import springboot.Model.PersonRepository;
import springboot.Service.ResultService;
import springboot.Service.RubricService;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService service;
    private final RubricService rubricService;
    private final PersonService personService;
    private final ResultService resultService;

//    private ItemController(ItemService service){
//        this.service = service;
//    }

    private ItemController(ItemService service, RubricService rubricService, PersonService personService, ResultService resultService){
        this.service = service;
        this.rubricService = rubricService;
        this.personService = personService;
        this.resultService = resultService;
    }

    @GetMapping(value = "/addItemPage")
    public String addItemPage(@ModelAttribute Item item, Model model) {
        Boolean authorized = false;
        Person user = personService.getUser();
        if (user != null && user.getType().equals("Instructor")){
            authorized = true;
        }
        if(!authorized){ return "unauthorizedUser"; }
        model.addAttribute("item", new Item());
        return "addItemPage";
    }

    @GetMapping(value = "/all")
    public String itemListPage(Model model) {
        Boolean authorized = false;
        Person user = personService.getUser();
        if (user != null && user.getType().equals("Instructor")){
            authorized = true;
        }
        if(!authorized){ return "unauthorizedUser"; }
        model.addAttribute("item", service.getAllItems());
        model.addAttribute("rubric", rubricService.getAllRubrics());
        return "itemListPage";
    }

    @PostMapping(value = "/add")
    public String addItem(@ModelAttribute Item item, Model model) {
        service.addItem(item);
        model.addAttribute("item", service.getAllItems());
        model.addAttribute("rubric", rubricService.getAllRubrics());
        return "itemListPage";
    }

    @GetMapping(value = "/selectReport")
    public String generateReports (Model model){
        model.addAttribute("person", personService.getAllPersons());
        return "selectReport";
    }

    @PostMapping(value = "/studentReport")
    public String studentReport (@RequestParam Integer student, Model model){
        model.addAttribute("student", personService.getPersonById(student));
        model.addAttribute("item", service.getAllItems());
        model.addAttribute("rubric", rubricService.getAllRubrics());
        model.addAttribute("resultService", resultService);
        return "studentReport";
    }

}