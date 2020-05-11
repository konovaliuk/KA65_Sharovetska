package kpi.iasa.StudentsTests.repoclasses;

import kpi.iasa.StudentsTests.repoclasses.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepoClass {

    private final QuestionRepository questionRepository;
}
