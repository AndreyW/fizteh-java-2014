package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable;

import ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable.
        MultiFileMapForJUnit.FileMapForMultiFileMapForJUnit.DataBase;

import java.util.HashMap;

public class DampingDataBase extends DataBase {

    public DampingDataBase() {
        data = new HashMap<>();
    }

    public DampingDataBase(HashMap<String, String> passedData) {
        data = new HashMap<>(passedData);
    }

    public void sync() throws Exception{
    }
}
