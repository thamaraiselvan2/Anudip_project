import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteExpense extends JFrame implements ActionListener {

    JTextField idField;
    JButton deleteBtn;

    public DeleteExpense() {

        setTitle("Delete Expense");

        setSize(400,200);

        setLayout(new GridLayout(2,2));

        add(new JLabel("Expense ID"));

        idField = new JTextField();

        add(idField);

        deleteBtn = new JButton("Delete Expense");

        add(deleteBtn);

        deleteBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
            "DELETE FROM expenses WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(sql);

            ps.setInt(1,
            Integer.parseInt(idField.getText()));

            int result = ps.executeUpdate();

            JOptionPane.showMessageDialog(this,
            result + " record deleted");

        }

        catch(Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(this,
            "Delete Failed");

        }

    }

}