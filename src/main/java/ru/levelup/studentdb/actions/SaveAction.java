package ru.levelup.studentdb.actions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("savedbAction")
@Scope("prototype")
public class SaveAction implements Action {
    @Override
    public void setParams(String... param) {

    }

    @Override
    public void execute() {
        System.out.println("Save DB");
    }
}
