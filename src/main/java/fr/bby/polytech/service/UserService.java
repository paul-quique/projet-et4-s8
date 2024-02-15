package fr.bby.polytech.service;


import fr.bby.polytech.model.User;
import fr.bby.polytech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId
    ) {
        User user = userRepository.findById(userId).orElseThrow();
        return user;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails)  {
        User user = userRepository.findById(userId)
                .orElseThrow();

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        final User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();

        userRepository.delete(user);
    }



}
