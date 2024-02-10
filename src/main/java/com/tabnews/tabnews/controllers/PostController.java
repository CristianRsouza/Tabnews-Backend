package com.tabnews.tabnews.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tabnews.tabnews.models.PostModel;
import com.tabnews.tabnews.models.UserModel;
import com.tabnews.tabnews.repositories.PostRepository;
import com.tabnews.tabnews.repositories.UserRepository;

@RestController
@RequestMapping("/api/Posts")
public class PostController {

  @Autowired
  PostRepository postRepository;

  @Autowired
  UserRepository userRepository;

  @GetMapping 
  public List<PostModel> getPosts () {
    return postRepository.findAll();
  }
  Calendar calendar = Calendar.getInstance();

  @PostMapping
  public ResponseEntity<Object> register(@RequestBody PostModel newPost) {
        



      Optional<UserModel> optionalUser = userRepository.findById(newPost.getWriter_id());
      if(optionalUser.isPresent()) {
          UserModel user = optionalUser.get();

          if(user.getFeatures().getCreate_content().equals(true)) {
            
            postRepository.save(newPost);
  
            newPost.setWriter_id(user.getId());
            newPost.setDate(calendar.getTime());
                  if(newPost.getText().equals(null)) {
                 
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Escreva um texto para postar");
                  } 
          }

      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario nao existe");

      }
      

      return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
  }
  


}
