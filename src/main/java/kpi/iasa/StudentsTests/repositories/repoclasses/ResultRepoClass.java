package kpi.iasa.StudentsTests.repositories.repoclasses;

import kpi.iasa.StudentsTests.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ResultRepoClass{

    private final ResultRepository resultRepository;

}
