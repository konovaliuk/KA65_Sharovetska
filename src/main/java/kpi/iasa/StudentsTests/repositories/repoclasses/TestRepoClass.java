package kpi.iasa.StudentsTests.repositories.repoclasses;

import kpi.iasa.StudentsTests.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TestRepoClass {

    private final TestRepository testRepository;
}
