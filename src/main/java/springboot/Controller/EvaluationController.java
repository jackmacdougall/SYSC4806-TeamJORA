package springboot.Controller;

import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import springboot.Model.Result;
import springboot.Model.Rubric;
import springboot.Model.Person;B
import springboot.Service.PersonService;
import springboot.Service.ResultService;
import springboot.Service.RubricService;
import springboot.Service.StudentService;

@Controller
@RequestMapping("/rubric")
public class EvaluationController {
    private final RubricService rubricService;
    private final PersonService personService;
    private final ResultService resultService;
    private final StudentService studentService;

    private EvaluationController(RubricService service, PersonService personService, ResultService resultService, StudentService studentService) {
        this.rubricService = service;
        this.personService = personService;
        this.resultService = resultService;
        this.studentService = studentService;
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
        if (id) {
            model.addAttribute("evaluations", resultService.getById(id));
        } else if (studentId) {
            model.addAttribute("evaluations", resultService.getAllResultsByStudent(studentService.getById(studentId)));
        } else {
            model.addAttribute("evaluations", resultService.getAllResults());
        }
        return "evaluationListPage";
    }

    public String addEvaluationPage(@ModelAttribute Result result, Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("rubrics", rubricService.getAllRubrics());
        model.addAttribute("user", personService.getUser());
        return "addEvaluationPage";
    }
}
