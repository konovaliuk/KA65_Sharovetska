package kpi.iasa.StudentsTests.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {


    private String name;
    private List<ResultDto> results;
}
