import javax.swing.*;
import java.awt.*;

public class LibrarySearch {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campus Library Search");

        JLabel title = new JLabel("Campus Library Search", JLabel.CENTER);
        JTextField search = new JTextField(15);
        String[] categories = {"All", "Java", "Python", "Database"};
        JComboBox<String> category = new JComboBox<>(categories);
        JButton searchButton = new JButton("Search");

        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.add(search);
        searchPanel.add(category);
        searchPanel.add(searchButton);

        JPanel top = new JPanel(new BorderLayout());
        top.add(title, BorderLayout.NORTH);
        top.add(searchPanel, BorderLayout.SOUTH);

        JTextArea results = new JTextArea("Search results appear here");
        results.setEditable(false);

        JButton prev = new JButton("Prev");
        JButton next = new JButton("Next");
        JButton reserve = new JButton("Reserve");

        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(prev);
        bottom.add(next);
        bottom.add(reserve);

        JLabel status = new JLabel("Ready");
        JPanel footer = new JPanel(new BorderLayout());
        footer.add(bottom, BorderLayout.CENTER);
        footer.add(status, BorderLayout.SOUTH);

        frame.setLayout(new BorderLayout());
        frame.add(top, BorderLayout.NORTH);
        frame.add(new JScrollPane(results), BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);

        searchButton.addActionListener(e -> status.setText("Searching..."));

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
