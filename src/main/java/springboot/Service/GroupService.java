package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Group;
import springboot.Model.GroupRepository;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Iterable<Group> getAllGroups(){
        return groupRepository.findAll();
    }

    public void addGroup(Group group){
        groupRepository.save(group);
    }
}
