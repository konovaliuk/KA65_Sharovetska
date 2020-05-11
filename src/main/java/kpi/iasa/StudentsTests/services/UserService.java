package kpi.iasa.StudentsTests.services;

import kpi.iasa.StudentsTests.dto.ResultDto;
import kpi.iasa.StudentsTests.dto.UserDto;
import kpi.iasa.StudentsTests.dto.UserToCreateDto;
import kpi.iasa.StudentsTests.exceptions.QuickTestException;
import kpi.iasa.StudentsTests.models.Result;
import kpi.iasa.StudentsTests.models.User;
import kpi.iasa.StudentsTests.repoclasses.ResultRepoClass;
import kpi.iasa.StudentsTests.repoclasses.UserRepoClass;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserService {

    private final ResultRepoClass resultRepoClass;
    private final UserRepoClass userRepoClass;


    private boolean validatePhone(String phone) {
        String phonePattern = "(\\+380\\d{9})|\\d{9}|\\d{10}";
        return Pattern.compile(phonePattern).matcher(phone).matches();
    }

    public String addUser(UserToCreateDto dto) {
        try {
            if (!validatePhone(dto.getPhone())) {
                log.error("phone number is invalid");
                throw new QuickTestException("This number is not valid.");
            }
            User user = new User(dto);
            userRepoClass.save(user);
            return "User was created";
        } catch (Exception ex) {
            return "Oops! Please try again";
        }
    }

    public UserDto authorize(String login, String password) {
        UserDto userDto = new UserDto();
        try {
            Optional<User> userOpt = userRepoClass.authorize(login, password);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                List<Result> results = resultRepoClass.getAllByUser(user);
                List<ResultDto> resultDtos = new ArrayList<>();
                for (Result result : results) {
                    resultDtos.add(new ResultDto(user.getName(), result.getTest(), result.getMark(), String.valueOf(result.getDate())));
                }
                userDto.setName(user.getName());
                userDto.setResults(resultDtos);
            }
        } catch (Exception e) {
            log.error(e.getStackTrace());
        }
        return userDto;
    }


    public List<ResultDto> getAllResults() {
        List<ResultDto> resultDtos = new ArrayList<>();
        try {
            List<Result> results = resultRepoClass.findAll();
            for (Result result : results) {
                resultDtos.add(new ResultDto(
                        result.getUser().getName(),
                        result.getTest(),
                        result.getMark(),
                        String.valueOf(result.getDate())
                ));
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return resultDtos;
    }
}
