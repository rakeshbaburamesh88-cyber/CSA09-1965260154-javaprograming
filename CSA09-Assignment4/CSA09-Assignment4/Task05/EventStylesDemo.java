// Task 5.1 - the four event-handling styles (A to D), all calling the same convert() method.
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventStylesDemo extends JFrame implements ActionListener {

    private final JButton a = new JButton("A: Frame implements");
    private final JButton b = new JButton("B: Named inner class");
    private final JButton c = new JButton("C: Anonymous class");
    private final JButton d = new JButton("D: Lambda");

    // B. Named inner class
    class ConvertHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            convert("B (named inner class)");
        }
    }

    public EventStylesDemo() {
        super("Four Event-Handling Styles");
        setLayout(new FlowLayout());
        add(a); add(b); add(c); add(d);

        // A. Frame implements ActionListener
        a.addActionListener(this);

        // B. Named inner class
        b.addActionListener(new ConvertHandler());

        // C. Anonymous inner class
        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convert("C (anonymous inner class)");
            }
        });

        // D. Lambda expression
        d.addActionListener(e -> convert("D (lambda)"));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        convert("A (Frame implements ActionListener)");
    }

    void convert(String style) {
        System.out.println("Converted using style " + style);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventStylesDemo().setVisible(true));
    }
}
