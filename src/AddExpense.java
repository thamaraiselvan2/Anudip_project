import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddExpense extends JFrame implements ActionListener {

    JTextField titleField, amountField, categoryField, dateField;
    JButton saveBtn;

    public AddExpense() {

        setTitle("Add Expense");

        setSize(400,300);

        setLayout(new GridLayout(5,2));

        add(new JLabel("Title"));
        titleField = new JTextField();
        add(titleField);

        add(new JLabel("Amount"));
        amountField = new JTextField();
        add(amountField);

        add(new JLabel("Category"));
        categoryField = new JTextField();
        add(categoryField);

        add(new JLabel("Date (YYYY-MM-DD)"));
        dateField = new JTextField();
        add(dateField);

        saveBtn = new JButton("Save Expense");
        add(saveBtn);

        saveBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "INSERT INTO expenses(title, amount, category, expense_date) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, titleField.getText());

            ps.setDouble(2,
            Double.parseDouble(amountField.getText()));

            ps.setString(3, categoryField.getText());

            ps.setString(4, dateField.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
            "Expense Added Successfully");

            titleField.setText("");
            amountField.setText("");
            categoryField.setText("");
            dateField.setText("");

        }

        catch(Exception ex) {

            JOptionPane.showMessageDialog(this,
            "Database Error");

            ex.printStackTrace();
        }

    }
}