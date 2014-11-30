package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class TypeTransformer {
    private static final HashMap<String, Class<?>> ARRAY_OF_TYPES;
    private static final HashMap<Class<?>, String> STRINGS;

    static {
        ARRAY_OF_TYPES = new HashMap<>();

        ARRAY_OF_TYPES.put("long", Long.class);
        ARRAY_OF_TYPES.put("byte", Byte.class);
        ARRAY_OF_TYPES.put("float", Float.class);
        ARRAY_OF_TYPES.put("int", Integer.class);
        ARRAY_OF_TYPES.put("double", Double.class);
        ARRAY_OF_TYPES.put("String", String.class);
        ARRAY_OF_TYPES.put("boolean", Boolean.class);
    }

    static {
        STRINGS = new HashMap<>();

        STRINGS.put(Long.class, "long");
        STRINGS.put(Byte.class, "byte");
        STRINGS.put(Integer.class, "int");
        STRINGS.put(Float.class, "float");
        STRINGS.put(String.class, "String");
        STRINGS.put(Double.class, "double");
        STRINGS.put(Boolean.class, "boolean");
    }

    public static Class<?> typeByName(String name) throws IOException {
        if (!ARRAY_OF_TYPES.containsKey(name)) {
            throw new IOException("Unknown type name: " + name);
        }
        return ARRAY_OF_TYPES.get(name);
    }

    public static List<Class<?>> typeListFromString(String list) throws Exception {
        List<Class<?>> result = new Vector<>();
        for (String name: list.split("\\s+", 0)) {
            result.add(typeByName(name));
        }
        return result;
    }

    public static String nameByType(Class type) throws IllegalArgumentException {
        if (!STRINGS.containsKey(type)) {
            throw new IllegalArgumentException();
        }
        return STRINGS.get(type);
    }

    public static String stringFromTypeList(List<Class<?>> types) throws IllegalArgumentException {
        StringBuilder needString = new StringBuilder();
        for (Class type: types) {
            if (needString.length() > 0) {
                needString.append(" ");
            }
            needString.append(nameByType(type));
        }
        return needString.toString();
    }
}
