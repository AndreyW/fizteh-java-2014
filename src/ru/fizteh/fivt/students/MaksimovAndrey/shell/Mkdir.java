package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;



public class Mkdir extends Instruction {
    public Mkdir() {
        nameOfInstruction = "mkdir";
    }

    @Override
    public boolean startNeedInstruction(String[] arguments) {
        Path needPath = Paths.get(presentDirectory.toString(), arguments[1]).toAbsolutePath().normalize();
        try {
            Files.createDirectory(needPath);
        } catch (IOException e) {
            System.err.print(e.getMessage());
            System.exit(1);
        }
        return true;
    }
}

