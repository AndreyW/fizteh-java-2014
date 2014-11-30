package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.MultiFileMapForJUnit;

public interface AbstractCommandExecutor {
    void executeNextCommand(CommandGetter getter, DataBaseDir dbDir) throws Exception;
}

