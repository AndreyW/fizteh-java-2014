package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.
        MultiFileMapForJUnit.FileMapForMultiFileMapForJUnit;


public class Exit extends Command {

    public int numberOfArguments() {
        return 0;
    }

    @Override
    public void startNeedInstruction(DataBase base) throws Exception {
        throw new ExitException();
    }
}
