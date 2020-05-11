package kpi.iasa.StudentsTests.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Table(name = "result")
@Entity
@NoArgsConstructor
public class Result {

    @Id
    @GeneratedValue
    private Long id;

    private Double mark;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Test test;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User user;

    public Result(Double mark, LocalDateTime date, Test test, User user) {
        this.date = date;
        this.mark = mark;
        this.test = test;
        this.user = user;
    }
}

