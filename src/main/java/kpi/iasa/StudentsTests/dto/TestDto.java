package kpi.iasa.StudentsTests.dto;

import kpi.iasa.StudentsTests.models.Test;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class TestDto {

    private String title;
    private String subject;
    private String description;
    private List<String> tags;
    private String authorName;


    public TestDto(Test test){
        this.title = test.getTitle();
        this.subject = test.getSubject();
        this.description = test.getDescription();
        this.tags = Arrays.asList(test.getTags().split("<>"));
        this.authorName = test.getAuthor().getName();
    }
}
