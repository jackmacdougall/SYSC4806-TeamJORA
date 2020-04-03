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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

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
        if(!personService.isAuthorized()){ return "unauthorizedUser"; }

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

    @PostMapping(value = "/downloadReport")
    public String downloadReport (@RequestParam Integer studentID, Model model){
        List<String []> data = new ArrayList<String []>();
        Student student = (Student) personService.getPersonById(studentID);
        data.add(new String[] {"Report for " + student.getName(), "Student ID " + student.getId(), "Group " + student.getGroup()});
        data.add(new String[] {"Item ID", "Item", "Grade"});
        for(Item item : service.getAllItems()) {
            data.add(new String[] {String.valueOf(item.getId()), item.getName(), String.valueOf(student.getAverage(item, resultService))});
        }

        File csvDownload = new File(student.getName() + " Report "+ ".csv");
        try (PrintWriter pw = new PrintWriter(csvDownload)) {
            data.stream().map(this::convertToCSV).forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertTrue(csvDownload.exists());

        return "downloadComplete";
    }

    private String convertToCSV(String[] data) {
        return Stream.of(data).map(this::escapeSpecialCharacters).collect(Collectors.joining(","));
    }

    private String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("\'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }

}