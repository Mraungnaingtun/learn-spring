package com.trainSpringBoot.logant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.trainSpringBoot.logant.Entity.User;
import com.trainSpringBoot.logant.Projections.UserSummary;
import com.trainSpringBoot.logant.Service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/email-password")
    public UserSummary getUserByMailAndPassword(@RequestParam String email,@RequestParam String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }
    

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @GetMapping("/withPagination")
    public Page<User> getUsersWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id,asc") String[] sort) {

        Sort.Direction direction = Sort.Direction.fromString(sort[1]);
        Sort sortOrder = Sort.by(direction, sort[0]);

        return userService.getPaginatedUsers(page, size, sortOrder);
    }
}
