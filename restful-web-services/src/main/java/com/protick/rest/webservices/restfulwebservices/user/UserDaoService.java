package com.protick.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCounter = 0;

    static {
        users.add(new User(++userCounter, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCounter, "Eve", LocalDate.now().minusYears(26)));
        users.add(new User(++userCounter, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user) {
        user.setId(++userCounter);
        users.add(user);
        return user;
    }
}