package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.Model.Item;
import springboot.Model.Rubric;
import springboot.Service.RubricService;

@Controller
@RequestMapping("/rubric")
public class RubricController {
    private final RubricService service;

    private RubricController(RubricService service) { this.service = service; }

    @GetMapping(value="/add")
    public String addRubricPage() { return "addRubricPage"; }

    @PostMapping(value="/add")
    public String addRubric(@ModelAttribute("rubric") Rubric rubric, Model model) {
        service.addRubric(rubric);
        model.addAttribute("rubrics", service.getAllRubrics());
        return "itemListPage";
    }

    @GetMapping(value = "/all")
    public String allRubrics(Model model, Item id)

}
