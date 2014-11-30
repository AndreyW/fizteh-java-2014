package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.TableProvider;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.TableProviderFactory;

import java.io.IOException;

public class StructuredTableProviderFactory implements TableProviderFactory {

    @Override
    public TableProvider create(String path) throws IOException {
        if (path == null) {
            throw new IllegalArgumentException();
        } else {
            return new StructuredTableProvider(path);
        }
    }
}
