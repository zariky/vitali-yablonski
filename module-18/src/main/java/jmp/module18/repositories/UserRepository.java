package jmp.module18.repositories;

import jmp.module18.beans.User;

public interface UserRepository {

    public User findUserById(Long id);

}