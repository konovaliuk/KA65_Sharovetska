package kpi.iasa.StudentsTests.repoclasses.repositories;

import kpi.iasa.StudentsTests.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
