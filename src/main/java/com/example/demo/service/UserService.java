package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.rest.controller.contract.CreateUserRequest;

public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordService passwordService;

  public void create(CreateUserRequest request) {
    validate(request);
    User user = createUser(request);
    userRepository.save(user);
  }

  private void validate(CreateUserRequest request) {
    // TODO: validate user
  }
  private User createUser(CreateUserRequest request) {
    User user = new User();
    user.setUsername(request.getUsername());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setSurName(request.getSurName());

    String salt = passwordService.generateSalt();
    user.setPasswordSalt(salt);
    user.setPassword(passwordService.encryptPassword(request.getPassword(), salt));

    return user;
  }
}
