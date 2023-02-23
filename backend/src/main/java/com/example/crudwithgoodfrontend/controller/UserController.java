package com.example.crudwithgoodfrontend.controller;

import com.example.crudwithgoodfrontend.exception.UserNotFoundException;
import com.example.crudwithgoodfrontend.model.Example;
import com.example.crudwithgoodfrontend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user")
    List<Example> allUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/user")
    Example newUser(@RequestBody Example newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/user/{id}")
    Example getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    Example updateUser(@RequestBody Example newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() ->new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }


}
