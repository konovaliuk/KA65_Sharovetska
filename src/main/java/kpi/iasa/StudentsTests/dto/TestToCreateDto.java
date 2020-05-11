package kpi.iasa.StudentsTests.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestToCreateDto {

    private String title;
    private String  description;
    private String subject;
    private List<String> tags;
    private List<QuestionDto> questions;
    private Long authorId;

}
