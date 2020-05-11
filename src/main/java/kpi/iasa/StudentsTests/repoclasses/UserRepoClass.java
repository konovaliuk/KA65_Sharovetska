package kpi.iasa.StudentsTests.repoclasses;

import kpi.iasa.StudentsTests.models.User;
import kpi.iasa.StudentsTests.repoclasses.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepoClass {

    private final UserRepository userRepository;

    public Optional<User> authorize(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
