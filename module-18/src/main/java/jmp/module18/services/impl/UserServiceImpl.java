package jmp.module18.services.impl;

import jmp.module18.beans.User;
import jmp.module18.repositories.UserRepository;
import jmp.module18.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

}