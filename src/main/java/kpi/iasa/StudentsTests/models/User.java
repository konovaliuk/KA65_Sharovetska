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
    private String password;

    private String firstName;
    private String lastName;

    private String phone;
    private String role;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<Result> results;

    public User(UserToCreateDto dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.phone = dto.getPhone();
        this.role = dto.getRole();

    }

}
