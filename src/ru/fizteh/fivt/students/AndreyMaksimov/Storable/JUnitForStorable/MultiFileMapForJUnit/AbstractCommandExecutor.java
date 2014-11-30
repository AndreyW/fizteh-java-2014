package ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.MultiFileMapForJUnit;

public interface AbstractCommandExecutor {
    void executeNextCommand(CommandGetter getter, DataBaseDir dbDir) throws Exception;
}

