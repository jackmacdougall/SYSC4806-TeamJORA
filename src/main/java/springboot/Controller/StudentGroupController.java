package springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.Model.Student;
import springboot.Model.StudentGroup;
import springboot.Model.StudentRepository;

@Controller
public class StudentGroupController {
    private StudentGroup group = new StudentGroup("classroom", 5);
    @Autowired
    private StudentRepository studentRepository;

  @GetMapping(value = "/addStudent")
    public String getStudent(@RequestParam("studentID") String studentName, @RequestParam("studentID") int studentID, Model model) {
        model.addAttribute(new Student(studentName, studentID));
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@ModelAttribute Student student) {
        group.addStudent(student);
        studentRepository.save(student);

        return "viewGroup";
    }

}