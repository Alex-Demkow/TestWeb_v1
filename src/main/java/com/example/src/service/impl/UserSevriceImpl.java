package com.example.src.service.impl;

import com.example.src.model.User;
import com.example.src.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@Service
public class UserSevriceImpl implements UserService {
    private List<User> userList = Arrays.asList(
            new User("Stas", "sta@gmail.com"),
            new User("Anastas", "anast@gmail.com"),
            new User("Alex", "alex@gmail.com"),
            new User("Franc", "franc@gmail.com")
    );

    @Override
    public User createUser(User userToCreate) {
        userList = new ArrayList<>(userList);
        if (Objects.nonNull(userToCreate))
            userList.add(new User(userToCreate.getName(), userToCreate.getEmail()));
        return userToCreate;
    }

    @Override
    public User getUser(String userName) {
        userList = new ArrayList<>(userList);
        return userList.stream()
                .filter(item -> Objects.equals(item.getName(), userName))
                .findFirst()
                .orElse(null);
    }


    @Override
    public User updateUser(User userToUpdate) {

      User user = getUser(userToUpdate.getName());
      deleteUser(user.getName());
      user.setName(userToUpdate.getName());
      user.setEmail(userToUpdate.getEmail());
      user.setDog(userToUpdate.getDog().getName());
      return  createUser(user);
    }

    @Override
    public void deleteUser(String userName) {
        userList = new ArrayList<>(userList);
        userList.removeIf(pred -> Objects.equals(pred.getName(),userName));
//        for (User user : userList
//        ) {
//            if (Objects.equals(user.getName(), userName)) {
//                userList.remove(user);
//            }
//
//        }
    }

    @Override
    public List<User> getAllUserList() {
        return userList;
    }

    @Override
    public User addDog(User user) {
        return createUser(user);
    }
}
