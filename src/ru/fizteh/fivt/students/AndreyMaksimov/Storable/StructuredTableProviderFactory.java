package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

import java.io.IOException;

import ru.fizteh.fivt.students.MaksimovAndrey.Storable.structured.TableProvider;
import ru.fizteh.fivt.students.MaksimovAndrey.Storable.structured.TableProviderFactory;

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
