package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.service.Authorities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    Map<String, String> users = new HashMap<>();


    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals(users.get(user)) && password.equals(users.get(password))) {
            return Authorities.asList();
        } else {
            return null;
        }
    }
}
