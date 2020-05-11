package kpi.iasa.StudentsTests.repoclasses;

import kpi.iasa.StudentsTests.models.Test;
import kpi.iasa.StudentsTests.repoclasses.repositories.QuestionRepository;
import kpi.iasa.StudentsTests.repoclasses.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TestRepoClass {

    private final TestRepository testRepository;
    private final QuestionRepository questionRepository;

    @Transactional
    public void save(Test test){
        testRepository.save(test);
        questionRepository.saveAll(test.getQuestions());
    };


    public Optional<Test> findById(Long id){
        return testRepository.findById(id);
    }

}
