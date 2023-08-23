package com.precisionbio.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(users.size() + 1, "John", LocalDate.of(1990, 1, 1)));
        users.add(new User(users.size() + 1, "Jane", LocalDate.of(1991, 2, 2)));
        users.add(new User(users.size() + 1, "Jack", LocalDate.of(1992, 3, 3)));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User deleteById(int id) {
        users.removeIf(user -> user.getId() == id);
        return users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
