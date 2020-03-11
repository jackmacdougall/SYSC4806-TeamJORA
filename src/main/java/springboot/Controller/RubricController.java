package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.Model.Rubric;
import springboot.Model.RubricValue;

@Controller
public class RubricController {
    @GetMapping("/rubric")
    public string getRubric(@RequestParam string id, Model model) {
        return "rubricPage"
    }

    @PostMapping("/rubric")
    public string addRubric(@ModelAttribute Rubric rubric, Model model) {
        model.
    }
}
