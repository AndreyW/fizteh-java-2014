package ru.fizteh.fivt.students.MaksimovAndrey.Parellel.StoreableForParallel.JUnitForStorable;


public class SingleTableDataBaseDir extends JUnitDataBaseDir {
    HybridTable table;

    public SingleTableDataBaseDir(HybridTable passedTable) {
        table = passedTable;
    }

    public HybridTable getUsing() {
        return table;
    }
}
