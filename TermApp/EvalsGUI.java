package TermApp;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class EvalsGUI extends JFrame 
{
    TEMPARRAYS temp = new TEMPARRAYS();
    private JFrame frame;
    private JTextPane evalField;
    private JTextArea inputTextArea;
    private JButton upEval;
    private JButton delEval;
    private JButton closeEval;

    public EvalsGUI(){
        initalizeGUI();
    }


    private void initalizeGUI() 
    {
        frame = new JFrame(" Employee Evaluation");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(750, 500);
       frame.setLayout(new BorderLayout());

       //make the textpane that displays evaluations
       evalField = new JTextPane();
       evalField.setEditable(false);
       evalField.setFont(new Font("Arial", Font.PLAIN, 12));

       JScrollPane scrollPane = new JScrollPane(evalField);
       frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

       inputTextArea = new JTextArea();
       inputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));

       JPanel inputPanel = new JPanel(new BorderLayout());
       inputPanel.add(inputTextArea, BorderLayout.CENTER);
       
       upEval = new JButton("Update Evaluation");
       delEval = new JButton("Delete Evaluation");
       closeEval = new JButton("Close");
        // action listener for close button
        closeEval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    
       JPanel buttons = new JPanel(new FlowLayout());
       buttons.add(upEval);
       buttons.add(delEval);
       buttons.add(closeEval);

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

   
   
/*
private void updateEvaluation()
{
    String evalPerson = n.getEvaluator();
    String 

    evalPerson = JOptionPane.showInputDialog(this, "Enter the person Evaluating:", evalPerson);
    String evalDate = JOptionPane.showInputDialog(this, "Enter the date of the Evaluation:", evalDate);
    String Ans1 = JOptionPane.showInputDialog(this,"Enter the answer to Question 1:", Ans1);
    String Ans2 = JOptionPane.showInputDialog(this,"Enter the answer to Question 2:", Ans2);
    String Ans3 = JOptionPane.showInputDialog(this,"Enter the answer to Question 3:", Ans3);


    TEMPARRAYS tempA = new TEMPARRAYS();
    tempA.updateEvals(0, evalPerson, evalDate, Ans1, Ans2, Ans3);
} */

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


public static void main(String[] args) 
{
    SwingUtilities.invokeLater(() -> {
       EvalsGUI gui = new EvalsGUI();
    });
}
}
