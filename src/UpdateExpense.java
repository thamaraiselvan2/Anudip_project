import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateExpense extends JFrame implements ActionListener {

    JTextField idField, amountField;
    JButton updateBtn;

    public UpdateExpense() {

        setTitle("Update Expense");

        setSize(400,250);

        setLayout(new GridLayout(3,2));

        add(new JLabel("Expense ID"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("New Amount"));
        amountField = new JTextField();
        add(amountField);

        updateBtn = new JButton("Update Expense");
        add(updateBtn);

        updateBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "UPDATE expenses SET amount=? WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setDouble(1,
            Double.parseDouble(amountField.getText()));

            ps.setInt(2,
            Integer.parseInt(idField.getText()));

            int result = ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
            result + " record updated");

        }

        catch(Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(this,
            "Update Failed");

        }

    }

}