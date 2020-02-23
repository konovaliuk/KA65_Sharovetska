package kpi.iasa.StudentsTests.dto;

import lombok.Data;

@Data
public class UserToCreateDto {

    private String email;
    private String password;

    private String firstName;
    private String lastName;

    private String phone;

    private String role;

}
