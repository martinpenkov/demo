package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

  User getUserByUsername(String username);
  void deleteUserByUsername(String username);
}
