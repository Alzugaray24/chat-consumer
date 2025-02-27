package com.asessment.chat.services;

import com.asessment.chat.dtos.User;
import com.asessment.chat.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveUser(User user) {
        if (user.getMessage() != null) {
            user.getMessage().forEach(message -> {
                message.setUser(user);
                message.setId(null);
            });
        }
        userRepository.save(user);
        System.out.println("User " + user.getNickname() + " saved");
        System.out.println("Saved with id " + user.getId());

    }
}
