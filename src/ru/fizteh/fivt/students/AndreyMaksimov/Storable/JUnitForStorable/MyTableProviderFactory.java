package ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable;

import ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.strings.TableProvider;
import ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.strings.TableProviderFactory;

public class MyTableProviderFactory implements TableProviderFactory {

    @Override
    public TableProvider create(String dir) {
        if (dir == null) {
            throw new IllegalArgumentException();
        }
        return new MyTableProvider(dir);
    }
}
