package kpi.iasa.StudentsTests.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "result")
@Entity
public class Result {

    @Id
    private Long id;

    private Integer maxMark;
    private Integer mark;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Test test;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;
}

