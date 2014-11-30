package ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable;

public class JUnitExit extends JUnitCommand {
    @Override
    public void execute(JUnitDataBaseDir base) throws Exception {
        throw new ExitException();
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
