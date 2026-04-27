import javax.swing.*;
import java.awt.event.*;

public class ExpenseGuardGUI extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu expenseMenu;
    JMenuItem addExpense, viewExpense, updateExpense, deleteExpense;

    public ExpenseGuardGUI() {

        setTitle("ExpenseGuard Dashboard");

        setSize(500,400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuBar = new JMenuBar();

        expenseMenu = new JMenu("Manage Expenses");

        addExpense = new JMenuItem("Add Expense");
        viewExpense = new JMenuItem("View Expenses");
        updateExpense = new JMenuItem("Update Expense");
        deleteExpense = new JMenuItem("Delete Expense");

        expenseMenu.add(addExpense);
        expenseMenu.add(viewExpense);
        expenseMenu.add(updateExpense);
        expenseMenu.add(deleteExpense);

        menuBar.add(expenseMenu);

        setJMenuBar(menuBar);

        addExpense.addActionListener(this);
        viewExpense.addActionListener(this);
        updateExpense.addActionListener(this);
        deleteExpense.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==addExpense)
            new AddExpense();

        if(e.getSource()==viewExpense)
            new ViewExpense();

        if(e.getSource()==updateExpense)
            new UpdateExpense();

        if(e.getSource()==deleteExpense)
            new DeleteExpense();

    }

}