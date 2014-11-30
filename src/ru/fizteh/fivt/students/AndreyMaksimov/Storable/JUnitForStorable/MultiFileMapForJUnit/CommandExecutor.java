package ru.fizteh.fivt.students.MaksimovAndrey.Storable.JUnitForStorable.MultiFileMapForJUnit;

public class CommandExecutor implements AbstractCommandExecutor {
    @Override
    public final void executeNextCommand(CommandGetter getter, DataBaseDir dbDir) throws Exception {
        String needString = getter.nextCommand();
        Command command = Command.fromString(needString);
        command.startNeedInstruction(dbDir);
    }
}


