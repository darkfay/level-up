package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.GroupService;

@Component("addstudentAction")
@Scope("prototype")
@RequiredArgsConstructor
public class AddStudentToGroupAction implements Action {

    private final GroupService groupService;
    private String firstName;
    private String lastname;
    private String name;

    @Override
    public void setParams(String... param) {
        this.firstName = param[0];
        this.lastname = param[1];
        this.name = param[3];
    }

    @Override
    public void execute() {
        groupService.addStudentToGroup(this.firstName, this.lastname, this.name);
    }

}
