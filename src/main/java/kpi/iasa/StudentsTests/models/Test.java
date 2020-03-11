package kpi.iasa.StudentsTests.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test")
public class Test {

    @Id
    private Long id;

    private Long title;
    private String  description;
    private String theme;
    private Integer questionNumber;

    @OneToMany
    @JoinColumn(referencedColumnName = "id")
    private List<Question> questions;
}
