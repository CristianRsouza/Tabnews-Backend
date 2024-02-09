package com.tabnews.tabnews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FeaturesModel {
    @Id
    private Integer id;

    private boolean EditContent;
    private boolean EditSession;
    private boolean CreateSession;
    private boolean CreateContent;
    private boolean DeleteSession;
    private boolean DeleteContent;
    
    // Getters and setters
}
