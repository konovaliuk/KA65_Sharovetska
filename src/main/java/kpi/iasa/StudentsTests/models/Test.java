package kpi.iasa.StudentsTests.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
