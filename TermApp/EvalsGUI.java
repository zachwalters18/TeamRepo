package TermApp;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class EvalsGUI extends JFrame 
{
    private JTable evalsTable;
    TEMPARRAYS temp = new TEMPARRAYS();


    public EvalsGUI() 
    {
       setTitle("Employee Evaluation");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(750, 500);
       setLocationRelativeTo(null);

       JPanel panel = new JPanel(new GridLayout(5, 2));
       JLabel Evallabel = new JLabel("Evaulation");
       JButton updateEval = new JButton("Update Evaluation");
       JButton closeButton = new JButton("Close");

       DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Question 1:");
        model.addColumn("Answer 1:");
        model.addColumn("Question 2:");
        model.addColumn("Answer 2:");
        model.addColumn("Question 3:");
        model.addColumn("Answer 3:");

        evalsTable = new JTable(model);
        evalsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(evalsTable);
        add(scrollPane, BorderLayout.CENTER);

        



        closeButton.addActionListener(e -> 
        {
            dispose();
        });

        panel.add(Evallabel);
        panel.add(closeButton);
        panel.add(updateEval);

        add(panel);
        setVisible(true);

    }

    public static void main(String[] args) 
{
    SwingUtilities.invokeLater(() -> {
        new EvalsGUI();
    });
}
   
}