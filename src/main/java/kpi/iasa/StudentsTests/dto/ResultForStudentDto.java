package kpi.iasa.StudentsTests.dto;

import kpi.iasa.StudentsTests.models.Result;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResultForStudentDto {


    private LocalDateTime date;
    private Double mark;
    private List<PassedQuestionDto> questionResultList;
    private TestDto testDto;

    public void update(Result result, List<PassedQuestionDto> questionResultList) {
        this.date = result.getDate();
        this.testDto = new TestDto(result.getTest());
        this.mark = result.getMark();
        this.questionResultList = questionResultList;

    }
}

