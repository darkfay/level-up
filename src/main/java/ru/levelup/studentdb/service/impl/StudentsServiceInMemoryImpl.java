package ru.levelup.studentdb.service.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.DaoService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentsServiceInMemoryImpl implements StudentsService {

    @Getter
    private int counter;
    private final List<Student> students = new ArrayList<>();

    @Override
    public void save(Student student) {
        counter++;
        students.add(student);
    }

    @Override
    public List<Student> findAll() {

        return Collections.unmodifiableList(students);
    }

}
