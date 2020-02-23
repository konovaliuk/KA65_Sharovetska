package kpi.iasa.StudentsTests.controllers;

import kpi.iasa.StudentsTests.dto.UserToCreateDto;
import kpi.iasa.StudentsTests.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestController {

    public final UserService userService;

    @GetMapping("/bla")
    public String addQuestion(){
        return  "blablablablbalbalablablababl<br>Hello";//userService.addUser();
    }


    @PostMapping("/addUser")
    public String addUser(@RequestBody UserToCreateDto dto){
        log.info("User is created");
        return userService.addUser(dto);
    }

    @PostMapping("")
    public String createTest(){

        return "";
    }
};
