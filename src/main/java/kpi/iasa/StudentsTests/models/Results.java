package kpi.iasa.StudentsTests.models;

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Results {

    @Id
    private Long id;

    private Integer maxMark;
    private Integer mark;
    private LocalDateTime date;


}

