package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.StudentsService;

import java.util.List;

@Component("liststudentsAction")
@Scope("prototype")
@RequiredArgsConstructor
public class ListStudentsAction implements Action {

    private final StudentsService studentsService;

    @Override
    public void setParams(String... param) {

    }

    @Override
    public void execute() {
        List<Student> students = studentsService.findAll();
        students.forEach(student -> {
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName());
        });
    }
}
