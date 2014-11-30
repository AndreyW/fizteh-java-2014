package ru.fizteh.fivt.students.MaksimovAndrey.Storable;


import ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.MultiFileMapForJUnit.BatchMode;
import ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.MultiFileMapForJUnit.CommandGetter;
import ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.MultiFileMapForJUnit.InteractiveMode;
import ru.fizteh.fivt.students.MaksimovAndrey.Storable.structured.TableProviderFactory;



public class StoreableMain {
    public static void main(String[] args) {
        String path = System.getProperty("fizteh.db.dir");
        if (path == null) {
            System.err.println("No database directory name specified");
            System.exit(1);
        }
        boolean interactive = false;
        try {
            TableProviderFactory factory = new StructuredTableProviderFactory();
            StructuredTableProvider dbDir = (StructuredTableProvider) factory.create(path);
            CommandGetter getter;
            if (args.length == 0) {
                interactive = true;
                getter = new InteractiveMode();
            } else {
                getter = new BatchMode(args);
            }
            boolean exitStatus = false;
            do {
                try {
                    String s = getter.nextCommand();
                    Command command = Command.fromString(s);
                    command.execute(dbDir);
                } catch (ExitException e) {
                    exitStatus = true;
                } catch (Exception e) {
                    if (interactive) {
                        System.err.println(e.getMessage());
                        System.err.flush();
                    } else {
                        throw e;
                    }
                }
            } while (!exitStatus);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(2);
        }
    }
}
