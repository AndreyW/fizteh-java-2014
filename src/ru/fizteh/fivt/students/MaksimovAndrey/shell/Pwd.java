package ru.fizteh.fivt.students.MaksimovAndrey.shell;


public class Pwd extends Instruction {
    public Pwd() {
        NameOfInstruction = "pwd";
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments) {
        System.out.println(PresentDirectory.toString());
        return true;
    }
}
