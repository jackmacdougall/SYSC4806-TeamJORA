package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Result;
import springboot.Model.ResultRepository;
import springboot.Model.Student;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public Iterable<Result> getAllResults() { return resultRepository.findAll(); }

    public Iterable<Result> getAllResultsByStudent(Student student) { return resultRepository.findByStudent(student); }

    public void addResult(Result result) { resultRepository.save(result); }
}

