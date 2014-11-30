package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.strings.TableProvider;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.
        JUnitForStorable.strings.TableProviderFactory;

public class MyTableProviderFactory implements TableProviderFactory {

    @Override
    public TableProvider create(String dir) {
        if (dir == null) {
            throw new IllegalArgumentException();
        }
        return new MyTableProvider(dir);
    }
}
