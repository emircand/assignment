import java.util.ArrayList;

public class Table {
    private ArrayList<Row> rows;

    public Table() {
        rows = new ArrayList<>();
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    @Override
    public String toString() {
        return "Table{" +
                "rows=" + rows +
                '}';
    }
}
