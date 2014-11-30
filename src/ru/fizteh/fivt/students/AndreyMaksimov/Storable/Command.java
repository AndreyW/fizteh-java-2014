package ru.fizteh.fivt.students.MaksimovAndrey.Storable;

import java.util.HashMap;

public abstract class Command {
    private static final HashMap<String, Command> ARRAY_OF_COMMANDS;

    static {
        ARRAY_OF_COMMANDS = new HashMap<>();
        ARRAY_OF_COMMANDS.put("get", new GetSt());
        ARRAY_OF_COMMANDS.put("put", new PutSt());
        ARRAY_OF_COMMANDS.put("drop", new DropSt());
        ARRAY_OF_COMMANDS.put("list", new ListSt());
        ARRAY_OF_COMMANDS.put("exit", new ExitSt());
        ARRAY_OF_COMMANDS.put("size", new SizeSt());
        ARRAY_OF_COMMANDS.put("create", new CreateSt());
        ARRAY_OF_COMMANDS.put("remove", new RemoveSt());
        ARRAY_OF_COMMANDS.put("commit", new CommitSt());
        ARRAY_OF_COMMANDS.put("rollback", new RollBackSt());
        ARRAY_OF_COMMANDS.put("show_tables", new ShowTablesSt());
    }

    private static String replaceInnerSpaces(String s, char occur) throws Exception {
        boolean flag = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == occur) {
                flag = true;
            }
            if (flag && s.charAt(i) == ' ') {
                result.append('`');
            } else {
                result.append(s.charAt(i));
            }
        }
        if (!flag) {
            return null;
        }
        return result.toString();
    }

    public static Command fromString(String needString) throws Exception {
        if (needString.length() < 1) {
            throw new Exception("");
        }
        if (needString.length() > 4 && needString.substring(0, 5).equals("show ")) {
            needString = needString.replaceFirst(" ", "_");
        }
        if (needString.length() > 6 && needString.substring(0, 7).equals("create ")) {
            needString = replaceInnerSpaces(needString, '(');
            if (needString == null) {
                throw new Exception("wrong type (create statement must have types in ())");
            }
        }
        if (needString.length() > 3 && needString.substring(0, 4).equals("put ")) {
            needString = replaceInnerSpaces(needString, '<');
            if (needString == null) {
                throw new Exception("wrong type (value must be xml-serialized)");
            }
        }

        String[] tokens = needString.split("\\s+, 0");
        if (ARRAY_OF_COMMANDS.containsKey(tokens[0])) {
            Command command = ARRAY_OF_COMMANDS.get(tokens[0]);
            if (tokens.length - 1 != command.numberOfArguments()) {
                throw new Exception("Wrong number of arguments: " + command.numberOfArguments());
            }
            command.putArguments(tokens);
            return command;
        } else {
            throw new Exception(tokens[0] + "wrong command");
        }
    }

    public abstract void execute(StructuredTableProvider base) throws Exception;
    protected void putArguments(String[] args) throws Exception {

    }
    protected abstract int numberOfArguments();
}
