package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Instructor;
import springboot.Model.InstructorRepository;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;

    public Iterable<Instructor> getAllInstructors() { return instructorRepository.findAll(); }

    public void addInstructor(Instructor instructor) { instructorRepository.save(instructor); }
}
