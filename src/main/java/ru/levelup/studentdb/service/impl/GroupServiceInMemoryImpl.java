package ru.levelup.studentdb.service.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.model.Student;
import ru.levelup.studentdb.service.GroupService;
import ru.levelup.studentdb.service.StudentsService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupServiceInMemoryImpl implements GroupService {

    @Autowired
    StudentsService studentsService;

    @Getter
    private int counter;
    private final List<Group> groups = new ArrayList<>();

    @Override
    public void save(Group group) {
        counter++;
        groups.add(group);
    }

    @Override
    public List<Group> findAll() {

        return Collections.unmodifiableList(groups);
    }

    public void addStudentToGroup(String firstName, String lastname, String name) {
        List<Student> students = studentsService.findAll();
        List<Group> groups = findAll();
        Student student = new Student(firstName, lastname);
        Group group = groups.stream().filter(gr -> gr.getName() != null && gr.getName().equals(name)).findAny().orElse(null);

        if (!students.isEmpty()) {
            if (students.contains(student)) {
                if (!groups.isEmpty()) {
                    if (groups.contains(group)) {
                        List<Student> studentsList = group.getStudents();

                        try {
                            studentsList.add(student);
                            group.setStudents(studentsList);
                        } catch (NullPointerException e) {
                            List<Student> studentsListNew = new ArrayList<>();
                            studentsListNew.add(student);
                            group.setStudents(studentsListNew);
                        }

                    } else {
                        System.out.println("The group does not exist. Type 'list groups' to see group list.");
                    }

                } else {
                    System.out.println("Group list is empty. First create a group, type 'create group <group_name>'");
                }
            } else {
                System.out.println("The student does not exist. Type 'list students' to see students list.");
            }

        } else {
            System.out.println("Student list is empty. First add a student. Type 'create student <first_name> <last_name>'");
        }
    }
}


//        if (students!= null){
//            students.forEach(student -> {
//                if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastname)) {
//                    if (groups != null) {
//                        System.out.println(groups);
//                        groups.forEach(group -> {
//                            if (group.getName().equals(name)) {
//
//                                group.setStudents(student);
//                                System.out.println(group.getStudents());
//                            } else {
//                                System.out.println("The group does not exist. Type 'list groups' to see group list.");
//                            }
//                        });
//                    }
//

//                }
//                else {
//                    System.out.println("The student does not exist. Type 'list students' to see students list.");
//                }
//            });
//        }
//        else {
//            System.out.println("Student list is empty. First add a student. Type 'create student <first_name> <last_name>'");
//        }

