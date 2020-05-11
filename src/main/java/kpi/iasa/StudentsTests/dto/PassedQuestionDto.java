package kpi.iasa.StudentsTests.dto;

import lombok.Data;

@Data
public class PassedQuestionDto {

    private String question;
    private String correctAnswer;
    private String userAnswer;
    private Boolean correct;

    public PassedQuestionDto(String question, String correctAnswer, String userAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;

    }
}
