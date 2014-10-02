package ru.fizteh.fivt.students.MaksimovAndrey.shell;


import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.DirectoryStream;

public class Ls extends Instruction {
    public Ls() {
        NameOfInstruction = "ls";
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(PresentDirectory)) {
            for (Path entry : directoryStream) {
                Path filePath = entry.getFileName();
                if (!Files.isHidden(filePath)) {
                    System.out.println(filePath.toString());
                }
            }
        } catch (IOException e) {
            System.err.print(e.getMessage());
            System.exit(1);
        }
        return true;
    }
}


