package kpi.iasa.StudentsTests.services;

import kpi.iasa.StudentsTests.dto.*;
import kpi.iasa.StudentsTests.models.Question;
import kpi.iasa.StudentsTests.models.Result;
import kpi.iasa.StudentsTests.models.Test;
import kpi.iasa.StudentsTests.models.User;
import kpi.iasa.StudentsTests.repoclasses.ResultRepoClass;
import kpi.iasa.StudentsTests.repoclasses.TestRepoClass;
import kpi.iasa.StudentsTests.repoclasses.UserRepoClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class TestService {

    private final UserRepoClass userRepoClass;
    private final TestRepoClass testRepoClass;
    private final ResultRepoClass resultRepoClass;

    public String createTest(TestToCreateDto dto) {
        try {
            Optional<User> authorOptional = userRepoClass.findById(dto.getAuthorId());
            if (authorOptional.isPresent()) {
                User author = authorOptional.get();
                if (author.getRole().equalsIgnoreCase("admin")) {
                    Test test = new Test(dto);
                    test.setAuthor(author);
                    List<Question> questions = dto.getQuestions().stream().map(Question::new).collect(Collectors.toList());
                    questions.forEach(item -> item.setTest(test));
                    test.setQuestions(questions);
                    testRepoClass.save(test);
                    return "test " + dto.getTitle() + " has being created";
                }
                return "You do not have this permission";
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return "ooops! sth get wrong";
    }


    public ResultForStudentDto passTheTest(TestToPassDto dtoOfAnswer) {
        ResultForStudentDto resultDto = new ResultForStudentDto();
        Optional<Test> testOptional = testRepoClass.findById(dtoOfAnswer.getTestId());
        Optional<User> userOptional = userRepoClass.findById(dtoOfAnswer.getUserId());
        if ((testOptional.isPresent()) && (userOptional.isPresent())) {
            User student = userOptional.get();
            Test test = testOptional.get();
            int maxTestResult = test.getQuestions().stream().mapToInt(Question::getCost).sum();
            int testUserResult = 0;
            List<PassedQuestionDto> questionDtos = new ArrayList<>();
            for (int i = 0; i < test.getQuestions().size(); i++) {
                Question question = test.getQuestions().get(i);
                PassedQuestionDto questionDto = new PassedQuestionDto(question.getText(),
                        question.getCorrectAnswer(), dtoOfAnswer.getAnswers().get(1));
                if (test.getQuestions().get(i).getCorrectAnswer().equals(dtoOfAnswer.getAnswers().get(1))) {
                    testUserResult = +question.getCost();
                    questionDto.setCorrect(true);
                } else {
                    questionDto.setCorrect(false);
                }
                questionDtos.add(questionDto);
            }
            Result result = new Result((double) testUserResult / maxTestResult, LocalDateTime.now(), test, student);
            resultRepoClass.save(result);
            log.info("result of test has being saved");
            resultDto.update(result,questionDtos);
        }
        return resultDto;
    }


}
