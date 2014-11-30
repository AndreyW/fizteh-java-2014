package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

public class ExitSt extends Command {

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        throw new ExitException();
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
