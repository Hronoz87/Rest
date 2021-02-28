package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.service.Authorities;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    Map<String, String> users = new HashMap<>();

    @PostConstruct
    public void addToMap() {
        users.put("user1", "qqqq");
        users.put("user2", "wwww");
        users.put("user3", "eeee");
        users.put("user4", "rrrr");
    }

    public <K, V> List<Authorities> getUserAuthorities(String user, String password) {
        for (Map.Entry<String, String> entry : users.entrySet()) {
            K key = (K) entry.getKey();
            V value = (V) entry.getValue();
            if ((user.equals(key)) && (password.equals(value))) {
                return Authorities.asList();
            }
        }
        return Collections.emptyList();
    }
}
