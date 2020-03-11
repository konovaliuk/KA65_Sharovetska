package kpi.iasa.StudentsTests.repositories;

import kpi.iasa.StudentsTests.models.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
