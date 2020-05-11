package kpi.iasa.StudentsTests.models;


import kpi.iasa.StudentsTests.dto.UserToCreateDto;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    private String login;
    private String password;

    private String name;
    private String phone;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Result> results;

    @OneToMany(mappedBy = "author")
    private List<Test> tests;

    public User(UserToCreateDto dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.login = dto.getLogin();
        this.name = dto.getName();
        this.phone = dto.getPhone();
        this.role = dto.getRole();
    }

}
