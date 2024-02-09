package com.tabnews.tabnews.controllers;

import java.util.List;
import com.tabnews.tabnews.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabnews.tabnews.repositories.UserRepository;

@RestController
@RequestMapping("/api/Users")
public class UserController {
  
  @Autowired
  private UserRepository userRepository;
  
  @GetMapping
  public List<UserModel> getUsers() {
    return userRepository.findAll();
  }
  
  @PostMapping
  public ResponseEntity<Object> register(@RequestBody UserModel newUser) {
      UserModel existingEmail = userRepository.findByEmail(newUser.getEmail());  
      UserModel existingName = userRepository.findByUsername(newUser.getUsername());

      if (existingEmail != null) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
      }
      if (existingName != null) {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome ja esta sendo ultilizado");
      }

      newUser.setTabcash(0);
      newUser.setTabcoins(0);
      UserModel savedUser = userRepository.save(newUser);
  
      return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
  }
  
}
