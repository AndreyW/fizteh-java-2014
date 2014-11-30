package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.StructuredTableProviderFactory;
import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.structured.TableProviderFactory;

import java.io.IOException;


public class StructuredTableProviderFactoryTest {
    private TableProviderFactory factory;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Before
    public void before() {
        factory = new StructuredTableProviderFactory();
    }

    @Test
    public void create() throws IOException {
        factory.create(tmpFolder.newFolder().getAbsolutePath());
    }

    @Test(expected = IOException.class)
    public void createWithIncorrectArgument() throws IllegalArgumentException, IOException {
        factory.create(tmpFolder.newFile().getAbsolutePath());
    }
}
