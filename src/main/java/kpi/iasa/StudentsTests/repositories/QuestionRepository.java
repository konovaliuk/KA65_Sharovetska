package kpi.iasa.StudentsTests.repositories;

import kpi.iasa.StudentsTests.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
