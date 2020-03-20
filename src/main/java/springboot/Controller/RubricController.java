package springboot.Controller;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.Model.Item;
import springboot.Model.Rubric;
import springboot.Service.ItemService;
import springboot.Service.RubricService;

@Controller
@RequestMapping("/rubric")
public class RubricController {
    private final RubricService service;
    private final ItemService itemService;

    private RubricController(RubricService service, ItemService itemService) {
        this.service = service;
        this.itemService = itemService;
    }

    @GetMapping(value="/showall")
    public String rubricListPage(Model model) {
        model.addAttribute("rubric", service.getAllRubrics());
        return "rubricListPage";
    }

    @GetMapping(value="/")
    public String addRubricPage(@RequestParam Integer item, @ModelAttribute Rubric rubric, Model model) {
        model.addAttribute("item", itemService.findById(item));
        model.addAttribute("rubric", new Rubric(itemService.findById(item)));
        return "addRubricPage";
    }

    @PostMapping(value="/")
    public String addRubric(@ModelAttribute Rubric rubric, Model model) {
        service.addRubric(rubric);
        model.addAttribute("rubric", service.getAllRubrics());
        model.addAttribute("item", itemService.getAllItems());
        return "itemListPage";
    }

    @GetMapping(value = "/all")
    public String allRubrics(Model model, @RequestParam Item item) {
        model.addAttribute("rubric", service.getAllRubricsByItem(item));
        return "itemListPage";
    }

}
