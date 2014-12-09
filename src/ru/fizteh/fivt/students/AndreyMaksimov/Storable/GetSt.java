package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

public class GetSt extends Command {

    String key;

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            StoreableValue value = (StoreableValue) base.getUsing().get(key);
            if (value == null) {
                System.out.println("not found");
            } else {
                System.out.println("found");
                for (Object i : value.getValues()) {
                    System.out.println(i + " ");
                }
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
