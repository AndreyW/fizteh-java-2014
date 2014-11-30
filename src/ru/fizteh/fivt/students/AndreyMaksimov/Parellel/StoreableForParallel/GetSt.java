package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.Storeable;

public class GetSt extends Command {

    String key;

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            Storeable value = base.getUsing().get(key);
            if (value == null) {
                System.out.println("not found");
            } else {
                System.out.println("found");
                System.out.println(base.serialize(base.getUsing(), value));
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
