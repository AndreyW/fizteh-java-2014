package ru.fizteh.fivt.students.MaksimovAndrey.shell;

abstract public class Instruction
{
    protected String NameOfInstruction;
    //protected int Number;

    abstract public boolean StartNeedInstruction(String[] arguments); //We will override this class
/*
    @Override
    final public String toString()
    {
        return NameOfInstruction;
    }
*/
}
