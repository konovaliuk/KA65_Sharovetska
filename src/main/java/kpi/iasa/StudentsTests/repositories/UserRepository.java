package kpi.iasa.StudentsTests.repositories;

import kpi.iasa.StudentsTests.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
