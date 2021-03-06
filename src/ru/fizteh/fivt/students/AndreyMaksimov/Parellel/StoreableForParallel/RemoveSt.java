package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.Storeable;

public class RemoveSt extends Command {

    String key;

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            Storeable result = base.getUsing().remove(key);
            if (result == null) {
                System.out.println("not found");
            } else {
                System.out.println("removed");
            }
        }
    }

    @Override
    protected int numberOfArguments() {
        return 1;
    }

    @Override
    public void putArguments(String[] args) {
        key = args[1];
    }
}
