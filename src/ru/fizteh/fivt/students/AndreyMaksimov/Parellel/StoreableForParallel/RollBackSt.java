package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

public class RollBackSt extends Command {

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            System.out.println(base.getUsing().rollback());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
