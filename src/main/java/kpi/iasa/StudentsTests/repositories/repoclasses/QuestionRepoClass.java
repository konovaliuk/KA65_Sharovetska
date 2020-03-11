package kpi.iasa.StudentsTests.repositories.repoclasses;

import kpi.iasa.StudentsTests.models.Question;
import kpi.iasa.StudentsTests.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepoClass {

    private final QuestionRepository questionRepository;
}
