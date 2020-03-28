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

@Controller
@RequestMapping("/group")
public class GroupController {

    private final GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @GetMapping(value = "/addGroupPage")
    public String addGroupPage(Model model){
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