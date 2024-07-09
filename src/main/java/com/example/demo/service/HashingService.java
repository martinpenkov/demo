package com.example.demo.service;

import java.util.Base64;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;
import org.springframework.stereotype.Service;

@Service
public class HashingService {

  private static final Integer PARALLELISM = 2;
  private static final Integer MEMORY = 65536;
  private static final Integer ITERATIONS = 3;
  private static final Integer HASH_LENGTH = 32;

  public String hashPassword(String password, String salt) {
      Argon2BytesGenerator generator = new Argon2BytesGenerator();
      Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
          .withSalt(Base64.getDecoder().decode(salt))
          .withParallelism(PARALLELISM)
          .withMemoryAsKB(MEMORY)
          .withIterations(ITERATIONS);

      generator.init(builder.build());
      byte[] result = new byte[HASH_LENGTH];
      generator.generateBytes(password.toCharArray(), result);
      return Base64.getEncoder().encodeToString(result);
  }
}
