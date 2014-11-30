package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

public class SizeSt extends Command {

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            System.out.println(base.getUsing().size());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
