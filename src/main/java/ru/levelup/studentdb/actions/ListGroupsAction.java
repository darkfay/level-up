package ru.levelup.studentdb.actions;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.model.Group;
import ru.levelup.studentdb.service.GroupService;

import java.util.List;

@Component("listgroupsAction")
@Scope("prototype")
@RequiredArgsConstructor
public class ListGroupsAction implements Action {

    private final GroupService groupService;

    @Override
    public void setParams(String... param) {

    }

    @Override
    public void execute() {
        List<Group> groups = groupService.findAll();
        groups.forEach(group -> {
            System.out.println("Group " + group.getName());
        });

    }
}
