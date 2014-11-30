package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

import java.util.List;

public class ListSt extends Command {

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        if (base.getUsing() == null) {
            System.out.println("no table");
        } else {
            List<String> list = ((StructuredTable) base.getUsing()).list();
            StringBuilder result = new StringBuilder();
            for (String key : list) {
                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(key);
            }
            System.out.println(result.toString());
        }
    }

    @Override
    protected int numberOfArguments() {
        return 0;
    }
}


