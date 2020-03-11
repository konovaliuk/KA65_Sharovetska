package kpi.iasa.StudentsTests.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Question")
public class Question {

    @Id
    private Long id;

    private String text;

    private String correctAnswer;

    private String wrongAnswers;

    private String cost;

    @ManyToOne
    @JoinColumn
    private Test test;
}
