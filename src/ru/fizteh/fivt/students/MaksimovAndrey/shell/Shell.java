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
        Instruction CommandPwd = new Pwd();
        Instructions.put(CommandPwd.NameOfInstruction, CommandPwd);
        Instruction CommandExit = new Exit();
        Instructions.put(CommandExit.NameOfInstruction, CommandExit);
        Instruction CommandCp = new Cp();
        Instructions.put(CommandCp.NameOfInstruction, CommandCp);
        Instruction CommandMv = new Mv();
        Instructions.put(CommandMv.NameOfInstruction, CommandMv);

    }

    public boolean interactive() {

        System.out.print("$ ");

        String[] ParsedCommands;
        String[] NeedArguments;
        boolean CheckShell = true;

        try (Scanner IN = new Scanner(System.in))
        {
            while (CheckShell == true)
            {
                ParsedCommands = IN.nextLine().split(";");
                for (String FirstCommand : ParsedCommands)
                {
                    FirstCommand = FirstCommand.trim();//Remove unnecessary whitespace;

                    NeedArguments = FirstCommand.split("\\s+");

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

    public boolean batch(String[] arguments)
    {
        String[] ParsedCommands;
        String[] NeedArguments;
        boolean CheckShell = true;
        String SetOfInstructions = arguments[0];


        for(int i =1; i < arguments.length; ++i)
        {
            SetOfInstructions = SetOfInstructions + " " + arguments[i];
        }
        ParsedCommands = SetOfInstructions.split(";");
        for(String oneCommand : ParsedCommands) {
            NeedArguments = oneCommand.trim().split("\\s");

            Instruction ShellInstruction = Instructions.get(NeedArguments[0]);
            if (ShellInstruction == null) {
                System.out.println(NeedArguments[0] + "ERROR: No such command");
                CheckShell = false;
            } else {
                ShellInstruction.StartNeedInstruction(NeedArguments);//Нам месте мы получаем строку аргументов, которые потом необходимо преобразовать.....
                CheckShell = true;
            }
        }

        return CheckShell;
    }

}
