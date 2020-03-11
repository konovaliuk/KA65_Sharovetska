package kpi.iasa.StudentsTests.dto;

import lombok.Data;

@Data
public class QuestionToCreateDto {

    private String question;
    private String rightAnswer;
    private String listOfWrongAnswers;

}
