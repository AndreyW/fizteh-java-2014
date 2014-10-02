package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import static java.nio.file.StandardCopyOption.*;

public class Cp extends Instruction
{
    public Cp()
    {
        NameOfInstruction = "cp";
    }

    public String recursiveFlag = "-r";

    public void copyFile(final Path SourcePath, final Path DestinationPath, final boolean isRecursive) throws IOException
    {
        if (!Files.isDirectory(SourcePath))
        {
            Files.copy(SourcePath, DestinationPath, REPLACE_EXISTING);
        }
        else if (isRecursive)
        {
            Files.copy(SourcePath, DestinationPath, REPLACE_EXISTING);
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(SourcePath))
            {
                for (Path entryPath : directoryStream)
                {
                    copyFile(entryPath, DestinationPath.resolve(entryPath.getFileName()).normalize(), isRecursive);
                }
            }
        } else
        {
            throw new DirectoryNotEmptyException(SourcePath.getFileName() + " is a directory (not copied).");
        }
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments)
    {
        boolean isRecursive = (arguments.length >= 4) && (arguments[1].equals(recursiveFlag));

        String SourceFileName;
        String DestinationFileName;

        if (isRecursive)
        {
            SourceFileName = arguments[2];
            DestinationFileName = arguments[3];
        }
        else
        {
            SourceFileName = arguments[1];
            DestinationFileName = arguments[2];
        }
        Path SourcePath = PresentDirectory.resolve(SourceFileName).normalize();
        Path DestinationPath = PresentDirectory.resolve(DestinationFileName).resolve(SourcePath.getFileName()).normalize();

        if (Files.exists(SourcePath))
        {
            try
            {
                copyFile(SourcePath, DestinationPath, isRecursive);
            }
            catch (IOException e)
            {
                System.err.print(e.getMessage());
                System.exit(1);
            }
        }
        return true;
    }
}



