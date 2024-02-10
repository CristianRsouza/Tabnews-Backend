package com.tabnews.tabnews.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parent_id;
    private Integer writer_id;
    private String text;
    private Calendar date;

    public void setWriter_id(Integer writer_id) {
        this.writer_id = writer_id;
    }

    public void setDate(Date time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        this.date = calendar;
    }
}


