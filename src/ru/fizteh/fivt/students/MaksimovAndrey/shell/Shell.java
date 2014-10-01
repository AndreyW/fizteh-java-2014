package ru.fizteh.fivt.students.MaksimovAndrey.shell;

import java.util.Scanner;
import java.util.HashMap;

public class Shell {
    private HashMap<String, Instruction> Instructions;

    public Shell() {
        Instructions = new HashMap();

        Instruction CommandCd = new Cd();
        Instructions.put(CommandCd.NameOfInstruction, CommandCd);
        Instruction CommandMkdir = new Mkdir();
        Instructions.put(CommandMkdir.NameOfInstruction, CommandMkdir);
        Instruction CommandLs = new Ls();
        Instructions.put(CommandLs.NameOfInstruction, CommandLs);
        Instruction CommandCat = new Cat();
        Instructions.put(CommandCat.NameOfInstruction, CommandCat);
        Instruction CommandRm = new Rm();
        Instructions.put(CommandRm.NameOfInstruction, CommandRm);
    }

    boolean CheckShell = true;

    String[] ParsedCommands;
    String[] NeedArguments;

    public boolean interactive() {
        try (Scanner IN = new Scanner(System.in)) {
            while (CheckShell == true) {
                ParsedCommands = IN.nextLine().split(";");
                for (String FirstCommand : ParsedCommands) {
                    FirstCommand = FirstCommand.trim();//Remove unnecessary whitespace;

                    NeedArguments = FirstCommand.split("\\s+");

                    if (NeedArguments[0].equals("exit")) {
                        CheckShell = false;
                        break;
                    }

                    Instruction ShellInstruction = Instructions.get(NeedArguments[0]);
                    if (ShellInstruction == null) {
                        System.out.println(NeedArguments[0] + "ERROR: No such command");
                        CheckShell = false;
                    } else {
                        ShellInstruction.StartNeedInstruction(NeedArguments);//Нам месте мы получаем строку аргументов, которые потом необходимо преобразовать.....
                        CheckShell = true;
                    }

                }
            }

        }
        return CheckShell;
    }
}
