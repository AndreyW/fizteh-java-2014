package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.*;
import java.util.Scanner;
import java.io.IOException;


public class Rm extends Instruction {
    public Rm() {
        NameOfInstruction = "rm";
    }

    public String recursiveFlag = "-r";


    public void removeFile(Path filePath, boolean isRecursive) throws IOException {
        if (!Files.isDirectory(filePath)) {
            Files.delete(filePath);
        } else if (isRecursive) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(filePath)) {
                for (Path newFile : directoryStream) {
                    if (Files.isDirectory(newFile)) {
                        removeFile(newFile, true);
                    } else {
                        Files.delete(newFile);
                    }
                }
            } catch (IOException e) {
                System.err.print(e.getMessage());
                System.exit(1);
            }
            Files.delete(filePath);
        }
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments) {
        boolean isRecursive = (arguments.length >= 3) && (arguments[1].equals(recursiveFlag));
        String fileName;
        if (isRecursive) {
            fileName = arguments[2];
        } else {
            fileName = arguments[1];
        }

        Path NeedPath = Paths.get(fileName);
        if (!NeedPath.isAbsolute()) {
            NeedPath = Paths.get(PresentDirectory.toString(), fileName).toAbsolutePath().normalize();
        }
        if (Files.exists(NeedPath)) {
            try {
                removeFile(NeedPath, isRecursive);
            } catch (IOException e) {
                System.err.print(e.getMessage());
                System.exit(1);
            }
        }
        return true;
    }
}
