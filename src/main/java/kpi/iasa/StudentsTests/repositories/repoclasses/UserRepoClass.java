package kpi.iasa.StudentsTests.repositories.repoclasses;

import kpi.iasa.StudentsTests.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepoClass {

    private final UserRepository userRepository;
}
