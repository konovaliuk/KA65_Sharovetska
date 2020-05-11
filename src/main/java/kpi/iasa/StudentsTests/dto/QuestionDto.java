package kpi.iasa.StudentsTests.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {

    private String question;
    private String correctAnswer;
    private List<String> wrongAnswers;
    private Integer cost;
}
