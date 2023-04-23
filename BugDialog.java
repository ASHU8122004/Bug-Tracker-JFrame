import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BugDialog extends JDialog {
    private JTextField idField;
    private JTextField descriptionField;
    private JComboBox<String> statusComboBox;
    private JComboBox<String> priorityComboBox;
    private boolean okPressed = false;

    public BugDialog(JFrame parent) {
        super(parent, "Add Bug", true);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("ID:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10, 10, 10, 10);
        panel.add(idLabel, constraints);

        idField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(idField, constraints);

        JLabel descriptionLabel = new JLabel("Description:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(descriptionLabel, constraints);

        descriptionField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(descriptionField, constraints);

        JLabel statusLabel = new JLabel("Status:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(statusLabel, constraints);

        statusComboBox = new JComboBox<>(new String[] {"Open", "In Progress", "Resolved"});
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(statusComboBox, constraints);

        JLabel priorityLabel = new JLabel("Priority:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(priorityLabel, constraints);

        priorityComboBox = new JComboBox<>(new String[] {"Low", "Medium", "High"});
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(priorityComboBox, constraints);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                okPressed = true;
                dispose();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(okButton, constraints);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public Bug getBug() {
        Bug bug = new Bug();
        bug.setId(idField.getText());
        bug.setDescription(descriptionField.getText());
        bug.setStatus((String)statusComboBox.getSelectedItem());
        bug.setPriority((String)priorityComboBox.getSelectedItem());
        return bug;
    }

    public void setBug(Bug bug) {
        idField.setText(bug.getId());
        descriptionField.setText(bug.getDescription());
        statusComboBox.setSelectedItem(bug.getStatus());
        priorityComboBox.setSelectedItem(bug.getPriority());
    }

    public boolean isOkPressed() {
        return okPressed;
    }
}