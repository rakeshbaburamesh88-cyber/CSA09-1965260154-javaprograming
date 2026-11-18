import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class HospitalAppointment extends JFrame {
    private final Map<String, List<String>> doctors = new HashMap<>();
    private final JTextField patientId = new JTextField(12);
    private final JComboBox<String> department = new JComboBox<>();
    private final JComboBox<String> doctor = new JComboBox<>();
    private final JComboBox<String> timeSlot = new JComboBox<>(
            new String[]{"10:00 AM", "11:00 AM", "02:00 PM", "04:00 PM"});
    private final JButton book = new JButton("Book");
    private final JButton clear = new JButton("Clear");
    private final JLabel status = new JLabel("Ready");
    private final Set<String> booked = new HashSet<>();

    public HospitalAppointment() {
        super("Hospital Outpatient Appointment");

        // Load doctors once into a Map (O(1) lookup per department change)
        doctors.put("Cardiology", Arrays.asList("Doctor A", "Doctor B"));
        doctors.put("Neurology", Arrays.asList("Doctor C", "Doctor D"));
        for (String d : doctors.keySet()) department.addItem(d);

        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel("Patient ID"));    panel.add(patientId);
        panel.add(new JLabel("Department"));    panel.add(department);
        panel.add(new JLabel("Doctor"));        panel.add(doctor);
        panel.add(new JLabel("Time Slot"));     panel.add(timeSlot);
        panel.add(book);                        panel.add(clear);

        setLayout(new BorderLayout(5, 5));
        add(panel, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);

        department.addActionListener(e -> refreshDoctors());
        doctor.addActionListener(e -> status.setText("Doctor: " + doctor.getSelectedItem()));
        timeSlot.addActionListener(e -> status.setText("Time: " + timeSlot.getSelectedItem()));
        book.addActionListener(e -> bookAppointment());
        clear.addActionListener(e -> {
            patientId.setText("");
            department.setSelectedIndex(0);
            timeSlot.setSelectedIndex(0);
            status.setText("Cleared");
        });

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int c = JOptionPane.showConfirmDialog(HospitalAppointment.this,
                        "Close the application?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (c == JOptionPane.YES_OPTION) dispose();
            }
        });

        refreshDoctors();
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void refreshDoctors() {
        doctor.removeAllItems();
        String dep = (String) department.getSelectedItem();
        if (dep == null) return;
        for (String d : doctors.get(dep)) doctor.addItem(d);
    }

    private void bookAppointment() {
        String id = patientId.getText().trim();
        String dep = (String) department.getSelectedItem();
        String doc = (String) doctor.getSelectedItem();
        String time = (String) timeSlot.getSelectedItem();

        if (id.isEmpty()) status.setText("Error: Enter patient ID");
        else if (dep == null) status.setText("Error: Select department");
        else if (doc == null) status.setText("Error: Select doctor");
        else if (time == null) status.setText("Error: Select time slot");
        else {
            String key = doc + "|" + time;
            if (booked.contains(key)) {
                status.setText("Slot unavailable");
            } else {
                booked.add(key);
                status.setText("Appointment confirmed: " + doc + " at " + time);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HospitalAppointment().setVisible(true));
    }
}
