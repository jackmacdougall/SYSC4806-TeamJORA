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
    private final StudentService studentService;

    public GroupController(GroupService service, PersonService personService, StudentService studentService) {

        this.service = service;
        this.personService = personService;
        this.studentService = studentService;
    }

    @GetMapping(value = "/addGroupPage")

    public String addGroupPage(@ModelAttribute Group group, Model model){
        model.addAttribute("group", new Group());
        return "addGroupPage";
    }

    @GetMapping(value = "/all")
    public String groupListPage(Model model){
        model.addAttribute("groups", service.getAllGroups());
        model.addAttribute("students", studentService.getAllStudents());
        return "groupListPage";
    }

    @PostMapping(value = "/add")
    public String addGroup(@ModelAttribute("group") Group group, Model model){
        service.addGroup(group);
        model.addAttribute("groups", service.getAllGroups());
        model.addAttribute("students", studentService.getAllStudents());
        return "groupListPage";
    }

    @GetMapping(value = "/joingroup")
    public String joinGroup(@RequestParam("groupId") Integer groupId, Model model){
        Group group = service.getGroupById(groupId);
        Object o = personService.getUser();
        if(o != null) {
            if (o instanceof Student) {
                Student person = (Student) o;
                if(!group.isStudentInGroup(person)) {
                    service.addStudentToGroup(group, person);
                }
            }
            else if (o instanceof Instructor){
                model.addAttribute("group", service.getGroupById(groupId));
                model.addAttribute("students", studentService.getStudentsNotInGroup());
                return "instructorGroupPage";
            }
        }
        model.addAttribute("groups", service.getAllGroups());
        model.addAttribute("students", studentService.getAllStudents());
        return "groupListPage";
    }

    @GetMapping(value = "/addtogroup")
    public String addToGroup(@RequestParam("groupId") Integer groupId, @RequestParam("studentId") Integer studentId, Model model){
        Group group = service.getGroupById(groupId);
        Student student = studentService.getById(studentId);
        service.addStudentToGroup(group, student);
        model.addAttribute("group", group);
        model.addAttribute("students", studentService.getStudentsNotInGroup());
        return "instructorGroupPage";
    }
}