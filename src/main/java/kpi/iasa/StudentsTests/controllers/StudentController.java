package kpi.iasa.StudentsTests.controllers;

import kpi.iasa.StudentsTests.dto.*;
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
public class StudentController {

    private final UserService userService;
    private final TestService testService;


    @GetMapping("/autorize")
    public UserDto autorize(@RequestBody UserToAuthorizeDto dto) {
        return userService.authorize(dto.getLogin(), dto.getPassword());
    }


    @PostMapping("/pass-test")
    public ResultForStudentDto passTest(@RequestBody TestToPassDto dtoOfAnswer) {
        return testService.passTheTest(dtoOfAnswer);
    }

}
