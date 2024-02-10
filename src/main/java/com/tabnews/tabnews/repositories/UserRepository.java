package com.tabnews.tabnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabnews.tabnews.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

  UserModel findByEmail(String email);


  UserModel findByUsername(String username);




}
