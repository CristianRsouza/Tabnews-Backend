package com.tabnews.tabnews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    private List<FeaturesModel> features;

    private String bio;
    private Integer tabcoins;
    private Integer tabcash;

    private List<PostModel> userposts;
}
