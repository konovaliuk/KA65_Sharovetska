package kpi.iasa.StudentsTests.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Question")
public class Question {

    @Id
    private Long id;

    private String text;

    private String correctAnswer;

    private String wrongAnswers;

    private String cost;

}
