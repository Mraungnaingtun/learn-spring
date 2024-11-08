package com.trainSpringBoot.logant.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.trainSpringBoot.logant.Entity.User;
import com.trainSpringBoot.logant.Projections.UserSummary;
import com.trainSpringBoot.logant.Repository.UserRepo;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> System.out.println(user.getName()));
        return users;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public UserSummary getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public Page<User> getPaginatedUsers(int page, int size, Sort sort) {
        return userRepository.findAll(PageRequest.of(page, size, sort));
    }

    // Streamble
    public List<User> getUserNameContain(String name) {
        return userRepository.findByNameContaining(name, Sort.by("name")
                .ascending())
                .stream()
                .filter(user -> user.getName().length() > 3 && !user.getEmail().equals(""))
                .toList();
    }
}
