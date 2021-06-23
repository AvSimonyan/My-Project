package com.example.bookrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    public int id;
    public int userId;
    public String title;
    public boolean completed;



}
