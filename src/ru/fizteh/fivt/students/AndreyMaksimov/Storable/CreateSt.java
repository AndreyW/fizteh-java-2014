package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

import ru.fizteh.fivt.students.MaksimovAndrey.Storable.structured.Table;

import java.util.List;
import java.io.IOException;


public class CreateSt extends Command {

    List<Class<?>> types;
    String name;

    @Override
    public void execute(StructuredTableProvider base) throws Exception {
        Table newtable = base.createTable(name, types);
        if (newtable == null) {
            System.out.println(name + " exists");
        } else {
            System.out.println("created");
        }
    }

    @Override
    protected int numberOfArguments() {
        return 2;
    }

    @Override
    protected void putArguments(String[] args) throws Exception {
        name = args[1];
        if (args[2].charAt(0) != '(' || args[2].charAt(args[2].length() - 1) != ')') {
            throw new Exception("wrong type (second argument of create must be in ())");
        }
        String s = args[2].substring(1, args[2].length() - 1).replaceAll("`", " ");
        try {
            types = TypeTransformer.typeListFromString(s);
        } catch (IOException e) {
            throw new Exception("wrong type (" + e.getMessage() + ")");
        }
    }

}

