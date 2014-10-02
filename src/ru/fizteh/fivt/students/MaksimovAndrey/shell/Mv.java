package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import static java.nio.file.StandardCopyOption.*;

public class Mv extends Instruction
{
    public Mv()
    {
        NameOfInstruction ="mv";
    }

    public void copyFile(final Path SourcePath, final Path DestinationPath, final boolean isRecursive) throws IOException
    {
        if (!Files.isDirectory(SourcePath))
        {
            Files.copy(SourcePath, DestinationPath, REPLACE_EXISTING);
            Files.delete(SourcePath); //Удалили файл на данном шаге;
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
        }
        else
        {
            throw new DirectoryNotEmptyException(SourcePath.getFileName() + " is a directory (not copied).");
        }
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments)
    {

        String SourceFileName = arguments[1];
        String DestinationFileName = arguments[2];

        Path SourcePath = PresentDirectory.resolve(SourceFileName).normalize();
        Path DestinationPath = PresentDirectory.resolve(DestinationFileName).resolve(SourcePath.getFileName()).normalize();

        boolean isRecursive;

        if (Files.exists(SourcePath))
        {
            if(Files.isDirectory(SourcePath))
            {
                isRecursive = true;
            }
            else
            {
                isRecursive = false;
            }

            try
            {
                copyFile(SourcePath, DestinationPath, isRecursive);
                if(isRecursive)
                {
                    Files.delete(SourcePath);
                }
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
