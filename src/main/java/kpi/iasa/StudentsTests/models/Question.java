package kpi.iasa.StudentsTests.models;

import kpi.iasa.StudentsTests.dto.QuestionDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "question")
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    private String correctAnswer;

    private String wrongAnswers;

    private Integer cost;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Test test;


    public Question(QuestionDto questionDto) {
        this.wrongAnswers = String.join("; ", questionDto.getWrongAnswers());
        this.cost = questionDto.getCost();
        this.correctAnswer = questionDto.getCorrectAnswer();
        this.text = questionDto.getQuestion();
    }
}
