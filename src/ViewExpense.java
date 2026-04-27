import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ViewExpense extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewExpense() {

        setTitle("View Expenses");

        setSize(600,400);

        model = new DefaultTableModel();

        table = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Amount");
        model.addColumn("Category");
        model.addColumn("Date");

        JScrollPane sp = new JScrollPane(table);

        add(sp, BorderLayout.CENTER);

        loadData();

        setVisible(true);
    }


    void loadData() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(
            "SELECT * FROM expenses");

            while(rs.next()) {

                model.addRow(new Object[] {

                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getDate("expense_date")

                });

            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

    }

}