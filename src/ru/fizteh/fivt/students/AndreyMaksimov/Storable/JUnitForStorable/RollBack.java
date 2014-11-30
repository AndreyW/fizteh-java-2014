package ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable;

public class RollBack extends JUnitCommand {

    @Override
    public void execute(JUnitDataBaseDir base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            System.out.println(base.getUsing().rollBack());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}
