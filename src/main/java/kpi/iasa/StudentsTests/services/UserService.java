package kpi.iasa.StudentsTests.services;

import kpi.iasa.StudentsTests.dto.UserToCreateDto;
import kpi.iasa.StudentsTests.exceptions.StudyException;
import kpi.iasa.StudentsTests.models.User;
import kpi.iasa.StudentsTests.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    public String addUser(UserToCreateDto dto) {
        try {
            if (!validatePhone(dto.getPhone())) {
                log.error("phone number is invalid");
                throw new StudyException("This number is not valid.");
            }

            User user = new User(dto);
            userRepository.save(user);
            return "User was created";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    private boolean validatePhone(String phone) {
        String phonePattern = "(\\+380\\d{9})|\\d{9}|\\d{10}";
        return Pattern.compile(phonePattern).matcher(phone).matches();
    }


}
