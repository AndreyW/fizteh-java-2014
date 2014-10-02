package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;



public class Mkdir extends Instruction {
    public Mkdir() {
        NameOfInstruction = "mkdir";
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments) {
        Path NeedPath = Paths.get(PresentDirectory.toString(), arguments[1]).toAbsolutePath().normalize();
        try {
            Files.createDirectory(NeedPath);
        } catch (IOException e) {
            System.err.print(e.getMessage());
            System.exit(1);
        }
        return true;
    }
}

