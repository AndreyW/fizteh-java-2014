package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

public class ShowTablesSt extends Command {

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        for (String name : base.getTableNames()) {
            System.out.println(name + " " + base.getTable(name).size());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
