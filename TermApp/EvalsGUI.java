package TermApp;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;


class EvalsGUI extends JFrame 
{
    TEMPARRAYS temp = new TEMPARRAYS();
    private JFrame frame;
    private JTextPane evalField;
    private JTextArea inputTextArea;
    private JButton upEval;
    private JButton delEval;
    private JButton closeEval;
    private JLabel evalLabel;


    public EvalsGUI() 
    {
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(750, 500);
       frame.setLocationRelativeTo(null);

       frame = new JFrame(" Employee Evaluation");
       upEval = new JButton("Update Evaluation");
       delEval = new JButton("Delete Evaluation");
       closeEval = new JButton("Close");
       
       frame.setBackground(Color.GRAY);
       upEval.setBackground(Color.BLUE);
       delEval.setBackground(Color.BLUE);
       closeEval.setBackground(Color.BLUE);


       // action listeners for all buttons
        closeEval.addActionListener(e -> 
        {
            dispose();
        });

        

        //make the textpane that displays evaluations
        evalField = new JTextPane();
        evalField.setEditable(false);
        evalField.setFont(new Font("Times New Roman", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(evalField);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputTextArea, BorderLayout.CENTER);

        frame.add(evalField);
        frame.add(closeEval);
        frame.add(delEval);
        frame.add(upEval);
        
        add(frame);
        frame.setVisible(true);
        

    }

    public static void main(String[] args) 
{
    SwingUtilities.invokeLater(() -> {
        new EvalsGUI();
    });
}
   

private void updateEvaluation()
{
    String evalPerson = JOptionPane.showInputDialog(this, "Enter the person Evaluating:", evalPerson);
    String evalDate = JOptionPane.showInputDialog(this, "Enter the date of the Evaluation:", evalDate);
    String Ans1 = JOptionPane.showInputDialog(this,"Enter the answer to Question 1:", Ans1);
    String Ans2 = JOptionPane.showInputDialog(this,"Enter the answer to Question 2:", Ans2);
    String Ans3 = JOptionPane.showInputDialog(this,"Enter the answer to Question 3:", Ans3);


    TEMPARRAYS tempA = new TEMPARRAYS();
    tempA.updateEvals(0, evalPerson, evalDate, Ans1, Ans2, Ans3);
}

public void displayEvaluation(Object n){
    StyledDocument eval = evalField.getStyledDocument();
    SimpleAttributeSet attributes = new SimpleAttributeSet();
    StyleConstants.setBold(attributes, true);

    try {
        eval.insertString(eval.getLength(), "Evaluation Information: \n", attributes);
        attributes = new SimpleAttributeSet();
        eval.insertString(eval.getLength(), n.toString() + "\n", attributes);

    } catch (BadLocationException e){
        e.printStackTrace();
    }

    
}
}
