package com.expmale.demo.controller;

import com.expmale.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers(Integer cnt) {
        log.info("Fetching users...");
        // In a real application, you would fetch users from a database or service

        return generateRandomUsers(cnt);
    }


    @GetMapping("/test")
    public List<String> test() {
        log.info("Testing endpoint...");
        return List.of("Test1", "Test2", "Test3");
    }

    private List<User> generateRandomUsers(Integer count) {
        count = (count == null || count <= 0) ? 10 : count; // Default to 10 users if count is not provided or invalid
        return new Random().ints(count, 1, 1000)
                .mapToObj(i -> generateRandomUser())
                .toList();
    }


    private User generateRandomUser() {
        Random random = new Random();
        long id = random.nextLong(1, 1000);
        String name = "User" + id;
        String email = "user" + id + "@example.com";
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}
