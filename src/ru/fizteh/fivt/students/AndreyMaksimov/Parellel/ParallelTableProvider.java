package ru.fizteh.fivt.students.MaksimovAndrey.Parellel;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.StructuredTable;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.Table;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.Storeable;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.StructuredTableProvider;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.TableProvider;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.StructuredTableProviderFactory;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.ColumnFormatException;


import java.util.List;
import java.util.HashMap;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ParallelTableProvider implements TableProvider {

    StructuredTableProvider oldProvider;
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    HashMap<String, ReentrantReadWriteLock> tableLocks;

    protected ParallelTableProvider(String path) throws IOException {
        StructuredTableProviderFactory factory = new StructuredTableProviderFactory();
        tableLocks = new HashMap<>();
        oldProvider = (StructuredTableProvider) factory.create(path);
        for (String name: oldProvider.getTableNames()) {
            tableLocks.put(name, new ReentrantReadWriteLock(true));
        }
    }

    @Override
    public Table getTable(String name) {
        lock.readLock().lock();
        try {
            StructuredTable origin = (StructuredTable) oldProvider.getTable(name);
            if (origin == null) {
                return null;
            } else {
                return new ParallelTable(origin, this, tableLocks.get(name));
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Table createTable(String name, List<Class<?>> columnTypes) throws IOException {
        lock.writeLock().lock();
        try {
            StructuredTable origin = (StructuredTable) oldProvider.createTable(name, columnTypes);
            if (origin == null) {
                return null;
            } else {
                tableLocks.put(name, new ReentrantReadWriteLock(true));
                return new ParallelTable(origin, this, tableLocks.get(name));
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void removeTable(String name) throws IOException {
        lock.writeLock().lock();
        try {
            oldProvider.removeTable(name);
            tableLocks.remove(name);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Storeable createFor(Table table) {
        return oldProvider.createFor(((ParallelTable) table).getStructuredTable());
    }

    @Override
    public Storeable createFor(Table table, List<?> values) throws ColumnFormatException, IndexOutOfBoundsException {
        return oldProvider.createFor(((ParallelTable) table).getStructuredTable(), values);
    }

    @Override
    public List<String> getTableNames() {
        lock.readLock().lock();
        try {
            return oldProvider.getTableNames();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Storeable deserialize(Table table, String value) throws ParseException {
        return oldProvider.deserialize(((ParallelTable) table).getStructuredTable(), value);
    }

    @Override
    public String serialize(Table table, Storeable value) throws ColumnFormatException {
        return oldProvider.serialize(((ParallelTable) table).getStructuredTable(), value);
    }
}
