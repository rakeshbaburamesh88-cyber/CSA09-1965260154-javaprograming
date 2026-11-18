import javax.swing.*;
import java.awt.*;

public class EventRegistration extends JFrame {
    JTextField id = new JTextField(12);
    JTextField name = new JTextField(12);
    JComboBox<String> event = new JComboBox<>(new String[]{
        "Dance Competition",
        "Singing Competition",
        "Technical Quiz"
    });
    JButton register = new JButton("Register");

    EventRegistration() {
        setTitle("Campus Event Registration");
        setLayout(new FlowLayout());
        add(new JLabel("Student ID"));
        add(id);
        add(new JLabel("Student Name"));
        add(name);
        add(new JLabel("Event"));
        add(event);
        add(register);

        register.addActionListener(e -> registerStudent());

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> dispose());
        file.add(exit);
        menuBar.add(file);
        setJMenuBar(menuBar);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void registerStudent() {
        String studentId = id.getText().trim();
        String studentName = name.getText().trim();

        if (studentId.isEmpty() || studentName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter all details");
            return;
        }

        // Event IDs match the INSERT order in schema.sql (1, 2, 3)
        int eventId = event.getSelectedIndex() + 1;
        RegistrationDAO dao = new RegistrationDAO();

        register.setEnabled(false);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                dao.register(studentId, studentName, eventId);
                return null;
            }

            @Override
            protected void done() {
                register.setEnabled(true);
                try {
                    get();
                    JOptionPane.showMessageDialog(EventRegistration.this,
                            "Registration successful");
                } catch (Exception ex) {
                    String msg = String.valueOf(ex.getCause());
                    if (msg.contains("Duplicate"))
                        JOptionPane.showMessageDialog(EventRegistration.this,
                                "Duplicate registration");
                    else
                        JOptionPane.showMessageDialog(EventRegistration.this,
                                "Registration failed");
                }
            }
        }.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventRegistration::new);
    }
}
