package ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.MultiFileMapForJUnit;

public class ExitMulti extends Command {

    protected int numberOfArguments() {
        return 0;
    }
    @Override
    public void startNeedInstruction(DataBaseDir base) throws Exception {
        throw new ExitException();
    }
}
