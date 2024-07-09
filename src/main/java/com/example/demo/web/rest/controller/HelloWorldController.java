package com.example.demo.web.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/api/v1/helloworld")
  public String helloWorld(){
    return "helloworld";
  }
}
