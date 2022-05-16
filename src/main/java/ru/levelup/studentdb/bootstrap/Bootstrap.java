package ru.levelup.studentdb.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.CommandProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CommandProcessor processor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please, enter command");
        System.out.print(">");

        // create student FirstName LastName
        // list students

        // create group GroupName
        // add student to a group
        // list groups

        // save
        // load

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!(line = reader.readLine()).equals("exit")) {
            String[] tokens = line.split(" ");
            String cmd = new StringBuilder().append(tokens[0]).append(tokens[1]).toString();
            processor.process(cmd, Arrays.copyOfRange(tokens, 1, tokens.length));
        }

        System.out.println();
    }

}
