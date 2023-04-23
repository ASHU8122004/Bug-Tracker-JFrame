import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BugTableModel extends AbstractTableModel {
private static final long serialVersionUID = 1L;
private static final String[] COLUMN_NAMES = { "ID", "Description", "Status", "Priority" };
private List<Bug> bugs = new ArrayList<>();
public int getRowCount() {
    return bugs.size();
}

public int getColumnCount() {
    return COLUMN_NAMES.length;
}

public Object getValueAt(int rowIndex, int columnIndex) {
    Bug bug = bugs.get(rowIndex);
    switch (columnIndex) {
    case 0:
        return bug.getId();
    case 1:
        return bug.getDescription();
    case 2:
        return bug.getStatus();
    case 3:
        return bug.getPriority();
    default:
        return null;
    }
}

public String getColumnName(int column) {
    return COLUMN_NAMES[column];
}

public void addBug(Bug bug) {
    bugs.add(bug);
    int index = bugs.size() - 1;
    fireTableRowsInserted(index, index);
}

public void updateBug(int index, Bug bug) {
    bugs.set(index, bug);
    fireTableRowsUpdated(index, index);
}

public void removeBug(int index) {
    bugs.remove(index);
    fireTableRowsDeleted(index, index);
}

public Bug getBug(int index) {
    return bugs.get(index);
}
}