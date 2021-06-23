package am.itspace.springdemo.service;

import am.itspace.springdemo.model.User;
import am.itspace.springdemo.repository.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);

    }

    public User getOne(int id) {
        return userRepository.getOne(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
