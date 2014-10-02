package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Cd extends Instruction {
    public Cd() {
        NameOfInstruction = "cd";
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments) {
        if (arguments.length == 1) {
            PresentDirectory = Paths.get("").toAbsolutePath().normalize();
            return true;
        }

        Path NeedAbsolutePath = Paths.get(arguments[1]);

        if (!NeedAbsolutePath.isAbsolute()) {
            NeedAbsolutePath = Paths.get(PresentDirectory.toString(), arguments[1]).toAbsolutePath().normalize();
        }
        System.out.println(NeedAbsolutePath.toString());

        if (Files.exists(NeedAbsolutePath) && Files.isDirectory(NeedAbsolutePath)) {
            PresentDirectory = NeedAbsolutePath;
        } else {
            System.out.println("ERROR: No such Directory or File");
        }
        return true;
    }
}