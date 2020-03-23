package springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import springboot.Model.GroupRepository;
import springboot.Model.Student;
import springboot.Model.Group;
import springboot.Model.StudentRepository;
import springboot.Service.GroupService;
import springboot.Service.PersonService;

import springboot.Model.*;
import springboot.Service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/group")
public class GroupController {

    private final GroupService service;
    private final PersonService personService;

    public GroupController(GroupService service, PersonService personService) {

        this.service = service;
        this.personService = personService;
    }

    @GetMapping(value = "/addGroupPage")

    public String addGroupPage(@ModelAttribute Group group, Model model){
        model.addAttribute("group", new Group());
        return "addGroupPage";
    }

    @GetMapping(value = "/all")
    public String groupListPage(Model model){
        model.addAttribute("groups", service.getAllGroups());
        return "groupListPage";
    }

    @PostMapping(value = "/add")
    public String addGroup(@ModelAttribute("group") Group group, Model model) {
        service.addGroup(group);
        model.addAttribute("groups", service.getAllGroups());
        return "groupListPage";
    }
}