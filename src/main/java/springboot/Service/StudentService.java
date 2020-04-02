package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springboot.Model.Student;
import springboot.Model.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getById(Integer id) { return studentRepository.findById(id).get(); }

    public void addStudent(Student student){
        studentRepository.save(student);
    }
}
