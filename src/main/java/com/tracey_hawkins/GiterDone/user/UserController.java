package com.tracey_hawkins.GiterDone.user;

import com.tracey_hawkins.GiterDone.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserRepository userRepository;
@Autowired
private PasswordEncoder passwordEncoder;
    @PostMapping("user")
    public User createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @GetMapping("user")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
    }

    @PutMapping("user/{id}")
    public User updateUser(@PathVariable("id")Long userId, @RequestBody User updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());

        return userRepository.save(user);
    }
    @DeleteMapping("user/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
       User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
      userRepository.delete(user);
    }

}
