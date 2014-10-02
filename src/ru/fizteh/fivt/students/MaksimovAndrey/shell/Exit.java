package ru.fizteh.fivt.students.MaksimovAndrey.shell;

public class Exit extends Instruction {
    public Exit() {
        NameOfInstruction = "exit";
    }

    @Override
    public boolean StartNeedInstruction(String[] arguments) {
        if (arguments[0].equals("exit")) {
            System.exit(0);
        }
        return true;
    }
}
