package springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.Model.GroupRepository;
import springboot.Model.Student;
import springboot.Model.Group;
import springboot.Model.StudentRepository;

@Controller
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

    @PostMapping(value = "/addGroup")
    public String addGroup(@RequestParam(value="name") String name) {
        groupRepository.save(new Group(name));
        return "/jorahome";
    }
}