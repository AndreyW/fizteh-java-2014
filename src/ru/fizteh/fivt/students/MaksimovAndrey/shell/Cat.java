package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class Cat extends Instruction
{
    public Cat()
    {
        NameOfInstruction = "cat";
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments)
    {
        String fileName = arguments[1];
        Path NeedPath = Paths.get(fileName);

        if (!NeedPath.isAbsolute())
        {
            NeedPath = Paths.get(PresentDirectory.toString(), fileName).toAbsolutePath().normalize();
        }
        if (Files.exists(NeedPath))
        {
            if (!Files.isDirectory(NeedPath))
            {
                try (Scanner scanner = new Scanner(Files.newInputStream(NeedPath)))
                {
                    while (scanner.hasNextLine())
                    {
                        System.out.println(scanner.nextLine());
                    }
                }
                catch (IOException e)
                {
                    System.err.print(e.getMessage());
                    System.exit(1);
                }
            }
        }
        return true;
    }
}

