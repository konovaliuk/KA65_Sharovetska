package kpi.iasa.StudentsTests.repoclasses;

import kpi.iasa.StudentsTests.models.Result;
import kpi.iasa.StudentsTests.models.User;
import kpi.iasa.StudentsTests.repoclasses.repositories.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResultRepoClass {

    private final ResultRepository resultRepository;

    public void save(Result result) {
        resultRepository.save(result);
    }

    public List<Result> findAll() {
        return resultRepository.findAll();
    }

    public List<Result> getAllByUser(User user) {
        return resultRepository.getAllByUser(user);
    }


}
