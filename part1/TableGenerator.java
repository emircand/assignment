package part1;
public abstract class TableGenerator {
    public static void generate (Table table) {
        table.addRow(new Row(1000,2000,12,100.51));
        table.addRow(new Row(1000,2001,31,200));
        table.addRow(new Row(1000,2002,22,150.86));
        table.addRow(new Row(1000,2003,41,250));
        table.addRow(new Row(1000,2004,55,244));
        table.addRow(new Row(1001,2001,88,44.531));
        table.addRow(new Row(1001,2002,121,88.11));
        table.addRow(new Row(1001,2004,74,211));
        table.addRow(new Row(1001,2002,14,88.11));
        table.addRow(new Row(1002,2003,2,12.1));
        table.addRow(new Row(1002,2004,3,22.3));
        table.addRow(new Row(1002,2003,8,12.1));
        table.addRow(new Row(1002,2002,16,94));
        table.addRow(new Row(1002,2005,9,44.1));
        table.addRow(new Row(1002,2006,19,90)); 
    }

    @Override
    public String toString() {
        return "TableGenerator";
    }
}
