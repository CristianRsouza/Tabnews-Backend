package com.tabnews.tabnews.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Features {
    private Boolean create_content;
    private Boolean create_session;
    private Boolean edit_content;
    private Boolean edit_user;
    private Boolean delete_content;
}
