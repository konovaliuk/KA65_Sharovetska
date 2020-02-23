package kpi.iasa.StudentsTests.repositories;

import kpi.iasa.StudentsTests.models.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
}
