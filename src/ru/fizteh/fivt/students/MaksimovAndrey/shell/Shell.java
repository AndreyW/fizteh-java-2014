package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.util.Scanner;
import java.util.HashMap;

public class Shell {
    private HashMap<String, Instruction> Instructions;

    public Shell() {
        Instructions = new HashMap();
    }

    boolean CheckShell = false;

    String[] ParsedCommands;
    String[] NeedArguments;

    public boolean interactive() {
        try (Scanner IN = new Scanner(System.in)) {
            while (CheckShell == false) {
                ParsedCommands = IN.nextLine().split(";");
                for (String FirstCommand : ParsedCommands) {
                    FirstCommand = FirstCommand.trim();//Remove unnecessary whitespace;

                    NeedArguments = FirstCommand.split("\\s+");

                    if (NeedArguments[0].equals("exit")) {
                        CheckShell = true;
                        break;
                    }

                    Instruction ShellInstruction = Instructions.get(NeedArguments[0]);
                    if (ShellInstruction == null) {
                        System.out.println(NeedArguments[0] + "ERROR: No such command");
                        CheckShell = true;
                    } else {
                        ShellInstruction.StartNeedInstruction(NeedArguments);
                        CheckShell = true;
                    }

                }
            }

        }
        return CheckShell;
    }
}
