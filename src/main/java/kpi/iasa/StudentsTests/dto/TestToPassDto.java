package kpi.iasa.StudentsTests.dto;

import lombok.Data;

import java.util.List;

@Data
public class TestToPassDto {

    private List<String> answers;
    private Long userId;
    private Long testId;
}
