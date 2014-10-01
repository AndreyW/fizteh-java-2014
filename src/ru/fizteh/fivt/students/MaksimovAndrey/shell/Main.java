package ru.fizteh.fivt.students.MaksimovAndrey.shell;

public class Main
{
    public static void main(String[] args)
    {
        Shell WShell = new Shell();

        boolean Check = true;

        if(args.length != 0)
        {
            /*Check = WShell.batch(args);*/
        }
        else
        {
            Check = WShell.interactive();
        }

        if(Check == false)
        {
            System.exit(1);
        }
        else
        {
            System.exit(0);
        }
    }
}
