package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.Model.Result;
import springboot.Service.*;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {
    private final RubricService rubricService;
    private final PersonService personService;
    private final ResultService resultService;
    private final StudentService studentService;
    private final ItemService itemService;

    private EvaluationController(RubricService service, PersonService personService, ResultService resultService, StudentService studentService, ItemService itemService) {
        this.rubricService = service;
        this.personService = personService;
        this.resultService = resultService;
        this.studentService = studentService;
        this.itemService = itemService;
    }

    @PostMapping(value = "/")
    public String addEvaluation(@ModelAttribute Result result, Model model) {
        this.resultService.addResult(result);
        model.addAttribute("evaluations", resultService.getAllResults());
        return "evaluationListPage";
    }

    @GetMapping(value = "/")
    public String getEvaluation(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) Integer studentId,
            @RequestParam(required = false) Integer rubricId,
            Model model) {
        if (id != null) {
            model.addAttribute("evaluations", resultService.getById(id));
        } else if (studentId != null) {
            model.addAttribute("evaluations", resultService.getAllResultsByStudent(studentService.getById(studentId)));
        } else {
            model.addAttribute("evaluations", resultService.getAllResults());
        }
        return "evaluationListPage";
    }

    @GetMapping(value = "/add")
    public String addEvaluationPage(Model model) {
        model.addAttribute("evaluation", new Result());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("rubrics", rubricService.getAllRubrics());
        model.addAttribute("user", personService.getUser());
        model.addAttribute("items", itemService.getAllItems());
        return "addEvaluationPage";
    }
}
