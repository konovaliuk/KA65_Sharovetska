package kpi.iasa.StudentsTests.dto;

import lombok.Data;

@Data
public class UserToCreateDto {

    private String email;
    private String password;

    private String name;
    private String login;

    private String phone;

    private String role;

}
