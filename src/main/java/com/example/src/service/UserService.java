package com.example.src.service;

import com.example.src.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public User createUser(User user);
    public User getUser(String userName);
    public User updateUser(User userToUpdate);
    public void deleteUser(String userName);
    public List<User> getAllUserList();

    public User addDog(User user);
}
