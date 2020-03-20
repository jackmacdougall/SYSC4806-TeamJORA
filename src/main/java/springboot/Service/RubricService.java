package springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.Model.Item;
import springboot.Model.Rubric;
import springboot.Model.RubricRepository;

@Service
public class RubricService {
    @Autowired
    private RubricRepository rubricRepository;

    public Iterable<Rubric> getAllRubrics() { return rubricRepository.findAll(); }

    public Iterable<Rubric> getAllRubricsByItem(Item item) { return rubricRepository.findByItem(item); }

    public void addRubric(Rubric rubric) { rubricRepository.save(rubric); }

}
