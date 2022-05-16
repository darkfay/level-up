package ru.levelup.studentdb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Group {
    private String name;
    private List<Student> students;

    public Group (String name){
        this.name = name;
    }
}
