package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.
        MultiFileMapForJUnit.Command;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.
        MultiFileMapForJUnit.GetMulti;

public class JUnitGet extends JUnitCommand {

    String key;

    @Override
    public void execute(JUnitDataBaseDir base) throws Exception {
        Command get = new GetMulti(key);
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            get.executeOnTable(base.getUsing().dirtyTable);
        }
    }

    protected final void putArguments(String[] args) {
        key = args[1];
    }

    @Override
    protected int numberOfArguments() {
        return 1;
    }
}
