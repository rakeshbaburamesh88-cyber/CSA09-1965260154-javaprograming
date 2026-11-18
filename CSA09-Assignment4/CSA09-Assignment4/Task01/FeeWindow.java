import java.awt.*;
import java.awt.event.*;

class FeeService {
    boolean validate(String regNo, double amount) {
        return !regNo.trim().isEmpty() && amount > 0;
    }

    String pay(String regNo, double amount) {
        if (!validate(regNo, amount))
            return "Invalid Details";
        return "Payment Successful";
    }
}

public class FeeWindow extends Frame {
    TextField regNo = new TextField(15);
    TextField amount = new TextField(15);
    Button pay = new Button("Pay");
    Button clear = new Button("Clear");
    Button receipt = new Button("Receipt");
    FeeService service = new FeeService();
    String lastReceipt = "";

    FeeWindow() {
        setTitle("Student Fee Payment");
        setLayout(new FlowLayout());
        add(new Label("Register Number:"));
        add(regNo);
        add(new Label("Amount:"));
        add(amount);
        add(pay);
        add(clear);
        add(receipt);

        pay.addActionListener(e -> {
            try {
                double a = Double.parseDouble(amount.getText());
                String result = service.pay(regNo.getText(), a);
                lastReceipt = result;
                if (result.equals("Payment Successful"))
                    lastReceipt += "\nRegister No: " + regNo.getText()
                            + "\nAmount: " + a;
                showMessage(result);
            } catch (NumberFormatException ex) {
                showMessage("Enter a valid amount");
            }
        });

        clear.addActionListener(e -> {
            regNo.setText("");
            amount.setText("");
        });

        receipt.addActionListener(e -> {
            showMessage(lastReceipt.isEmpty()
                    ? "No receipt available"
                    : lastReceipt);
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setSize(400, 250);
        setVisible(true);
    }

    void showMessage(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message);
    }

    public static void main(String[] args) {
        new FeeWindow();
    }
}
