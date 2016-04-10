package jmp.module18.repositories.impl;

import jmp.module18.beans.User;
import jmp.module18.repositories.UserRepository;
import org.springframework.stereotype.Repository;
import java.util.LinkedHashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private Map<Long, User> users = new LinkedHashMap<Long, User>(){{
        put(1L, new User("John"));
        put(2L, new User("Patrick"));
    }};

    public User findUserById(Long id) {
        return users.containsKey(id) ? users.get(id) : null;
    }

}