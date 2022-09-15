package com.example.finalproject.service;
import com.example.finalproject.dto.RegisterForm;
import com.example.finalproject.model.User;
import com.example.finalproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers() {

        return userRepository.findAll();
    }

    public void register(RegisterForm registerForm) {
        String hashedPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        User user = new User(null, registerForm.getNickName(), registerForm.getEmail(), registerForm.getPassword(), registerForm.getConfirmPassword(),null);
        userRepository.save(user);
}

    public void updateUser(User user, Integer id) {
        User oldUser = userRepository.getById(id);
        oldUser.setNickName(user.getNickName());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setConfirmPassword(user.getConfirmPassword());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }
}
