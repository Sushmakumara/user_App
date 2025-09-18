package com.nie.user.NIEUserApp.service;

import com.nie.user.NIEUserApp.models.User;
import com.nie.user.NIEUserApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //  Create or update user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    //  Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //  Get user by ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    //  Delete user by ID
    public boolean deleteUser(String id) {
        if (!userRepository.existsById(id)) {
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }

    //  Find by email
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    //  Find by username
    public Optional<User> getUserByUserName(String userName) {
        return Optional.ofNullable(userRepository.findByUserName(userName));
    }
}

