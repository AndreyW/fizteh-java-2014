package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

public class CommitSt extends Command {

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            System.out.println(base.getUsing().commit());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
