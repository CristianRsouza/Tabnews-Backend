package com.tabnews.tabnews.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tabnews.tabnews.models.PostModel;

public interface PostRepository extends JpaRepository<PostModel, Integer>{

  
}
