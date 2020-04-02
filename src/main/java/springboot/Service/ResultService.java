package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Result;
import springboot.Model.ResultRepository;
import springboot.Model.Rubric;
import springboot.Model.Student;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public Iterable<Result> getAllResults() { return resultRepository.findAll(); }

    public Result getById(Integer id) { return resultRepository.findById(id).get(); }

    public Iterable<Result> getAllResultsByStudent(Student student) { return resultRepository.findByStudent(student); }

    public Double getStudentAverageResult(Student student) {
        Double resultRubricTotal = 0.0;
        int resultCounter = 0;
        for(Result result : resultRepository.findByStudent(student)){
            resultRubricTotal += result.getRubric().getValue();
            resultCounter++;
        }
        if (resultCounter > 0){
            return resultRubricTotal/resultCounter;
        }
        else return 0.0;
    }

    public void addResult(Result result) { resultRepository.save(result); }
}

