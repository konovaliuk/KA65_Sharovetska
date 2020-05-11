package kpi.iasa.StudentsTests.controllers;

import kpi.iasa.StudentsTests.dto.ResultDto;
import kpi.iasa.StudentsTests.dto.TestToCreateDto;
import kpi.iasa.StudentsTests.dto.UserToCreateDto;
import kpi.iasa.StudentsTests.services.TestService;
import kpi.iasa.StudentsTests.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class AdminController {

    private final UserService userService;
    private final TestService testService;

    @PostMapping("/create-test")
    public String createTest(@RequestBody TestToCreateDto dto) {
        return testService.createTest(dto);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserToCreateDto dto) {
        log.info("User is created");
        return userService.addUser(dto);
    }


    @GetMapping("/getTableOfResults")
    public List<ResultDto> getListOfAllResults() {
        return userService.getAllResults();
    }


}
