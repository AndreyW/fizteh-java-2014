package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.
        MultiFileMapForJUnit.Command;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.
        MultiFileMapForJUnit.ShowTables;

public class JUnitShow extends JUnitCommand {
    @Override
    public void execute(JUnitDataBaseDir base) throws Exception {
        Command show = new ShowTables();
        show.startNeedInstruction(base.usualDbDir);
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
