package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.StructuredTableProviderFactory;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StoreableValueTest {
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    public Table table;
    Storeable storeable;
    List<Class<?>> types;

    @Before
    public void initTable() throws IOException {
        TableProviderFactory factory = new StructuredTableProviderFactory();
        String dbDirPath = tmpFolder.newFolder().getAbsolutePath();
        TableProvider provider = factory.create(dbDirPath);
        Class<?>[] arrayTypes = {Integer.class, Long.class, Float.class, Double.class,
                Boolean.class, String.class, Byte.class};
        types = Arrays.asList(arrayTypes);
        table = provider.createTable("table", types);
        storeable = provider.createFor(table);
    }

    @Test
    public void testSetAndGetColumns() {
        storeable.setColumnAt(0, 1);
        storeable.setColumnAt(1, 2L);
        storeable.setColumnAt(2, 3.2f);
        storeable.setColumnAt(3, 4.4);
        storeable.setColumnAt(4, true);
        storeable.setColumnAt(5, "hello");
        storeable.setColumnAt(6, (byte) 1);
        assertEquals(storeable.getIntAt(0), (Integer) 1);
        assertEquals(storeable.getLongAt(1), (Long) 2L);
        assertEquals(storeable.getFloatAt(2), (Float) 3.2f);
        assertEquals(storeable.getDoubleAt(3), (Double) 4.4);
        assertEquals(storeable.getBooleanAt(4), true);
        assertEquals(storeable.getStringAt(5), "hello");
        assertEquals(storeable.getByteAt(6), (Byte) (byte) 1);
        assertEquals(storeable.getColumnAt(4), true);
        storeable.setColumnAt(3, null);
        assertNull(storeable.getColumnAt(3));
        assertNull(storeable.getDoubleAt(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        storeable.getColumnAt(7);
    }

    @Test(expected = ColumnFormatException.class)
    public void testGetIncorrectType() {
        storeable.getByteAt(0);
    }
}

