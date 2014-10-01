package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.nio.file.Path;
import java.nio.file.Paths;

abstract public class Instruction
{
    protected String NameOfInstruction;
    protected static Path PresentDirectory = Paths.get("").toAbsolutePath().normalize();

    abstract public boolean StartNeedInstruction(String[] arguments);

    @Override
    final public String toString()
    {
        return NameOfInstruction;
    }
}
