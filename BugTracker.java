import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BugTracker extends JFrame {
private BugTableModel tableModel;
private JTable table;
public BugTracker() {
    super("Bug Tracker");

    tableModel = new BugTableModel();
    table = new JTable(tableModel);
    JScrollPane scrollPane = new JScrollPane(table);

    JPanel buttonPanel = new JPanel();
    JButton addButton = new JButton("Add Bug");
    addButton.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
            BugDialog dialog = new BugDialog(BugTracker.this);
            dialog.setVisible(true);
            Bug bug = dialog.getBug();
            if (bug != null) {
                tableModel.addBug(bug);
            }
        }
    });
    buttonPanel.add(addButton);

    JButton editButton = new JButton("Edit Bug");
    editButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(BugTracker.this, "Please select a bug to edit", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            BugDialog dialog = new BugDialog(BugTracker.this);
            dialog.setBug(tableModel.getBug(index));
            dialog.setVisible(true);
            Bug bug = dialog.getBug();
            if (bug != null) {
                tableModel
                .updateBug(index, bug);
            }
        }
    });
    buttonPanel.add(editButton);

    JButton removeButton = new JButton("Remove Bug");
    removeButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(BugTracker.this, "Please select a bug to remove", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(BugTracker.this,
                    "Are you sure you want to remove this bug?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeBug(index);
            }
        }
    });
    buttonPanel.add(removeButton);

    getContentPane().add(scrollPane, BorderLayout.CENTER);
    getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    setSize(800, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    BugTracker bugTracker = new BugTracker();
    bugTracker.setVisible(true);
}
}

