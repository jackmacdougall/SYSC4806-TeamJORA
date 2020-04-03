package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Group;
import springboot.Model.GroupRepository;
import springboot.Model.Student;
import springboot.Model.StudentRepository;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public void addGroup(Group group){
        groupRepository.save(group);
    }

    public void addStudentToGroup(Group group, Student student){
        student.joinGroup(group);
        studentRepository.save(student);
        groupRepository.save(group);
    }

    public Group getGroupById(Integer id) { return groupRepository.findById(id).get(); }
}
