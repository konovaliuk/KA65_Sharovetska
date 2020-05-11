package kpi.iasa.StudentsTests.models;

import kpi.iasa.StudentsTests.dto.TestToCreateDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "test")
@NoArgsConstructor
public class Test {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String subject;//like biology or history
    private String tags;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private User author;

    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER)
    private List<Question> questions;

    public Test(TestToCreateDto dto) {
        this.title = dto.getTitle();
        this.subject = dto.getSubject();
        this.tags = String.join("<>", dto.getTags());
        this.description = dto.getDescription();
    }
}
