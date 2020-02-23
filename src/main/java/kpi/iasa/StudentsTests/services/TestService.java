package kpi.iasa.StudentsTests.services;

import kpi.iasa.StudentsTests.dto.TestToCreateDto;
import kpi.iasa.StudentsTests.models.Test;
import kpi.iasa.StudentsTests.repositories.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public String createTest(TestToCreateDto dto){
        try{

            return "";
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

}
