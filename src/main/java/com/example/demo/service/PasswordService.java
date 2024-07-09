package com.example.demo.service;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordService {

  private HashingService hashingService;

  public String generateSalt(){
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);

    return Base64.getEncoder().encodeToString(salt);
  }

  public String encryptPassword(String password, String salt) {
    // TODO: check password complexity
    return hashingService.hashPassword(password, salt);
  }
}
