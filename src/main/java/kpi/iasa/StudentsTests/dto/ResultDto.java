package kpi.iasa.StudentsTests.dto;

import kpi.iasa.StudentsTests.models.Test;
import lombok.Data;

@Data
public class ResultDto {

    private String studentName;
    private TestDto testDto;
    private Double mark;
    private String date;

    public ResultDto(String name, Test test,Double mark, String date) {
        this.studentName = name;
        this.testDto = new TestDto(test);
        this.mark = mark;
        this.date = date;
    }
}
