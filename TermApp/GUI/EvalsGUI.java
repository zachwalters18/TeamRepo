package TermApp;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class EvalsGUI extends JFrame 
{
    
    private JFrame frame;
    private JTextPane evalField;
    private JButton upEval;
    private JButton delEval;
    private JButton closeEval;
    private JButton zoomIn;
    private JButton zoomOut;
    private int evalIndex;
    private JButton viewEval;
    private JButton addEval;


    public EvalsGUI(){
        initalizeGUI();
    }


    private void initalizeGUI() 
    {
        TEMPARRAYS temp = new TEMPARRAYS();
        temp.makeFakeEvals();

        frame = new JFrame(" Employee Evaluation");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(750, 500);
       frame.setLayout(new BorderLayout());

       //make the textpane that displays evaluations
       evalField = new JTextPane();
       evalField.setEditable(false);
       evalField.setText(temp.displayEvals(0));
       evalField.setFont(new Font("Arial", Font.PLAIN, 18));
       evalField.setPreferredSize(new Dimension(1440, 1080));

       JScrollPane scrollPane = new JScrollPane(evalField);
       frame.add(scrollPane, BorderLayout.CENTER);

       
       upEval = new JButton("Update Evaluation");
       upEval.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateEvaluation(temp.Evaluations[evalIndex]); // Call your update method with the selected object
        }
    });

       delEval = new JButton("Delete Evaluation");
       delEval.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            deleteEvaluations(evalIndex);
        }
    });
       closeEval = new JButton("Close");
        // action listener for close button
        closeEval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(closeEval);
                topFrame.dispose();
            }
        });
        zoomIn = new JButton("+");
        zoomIn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                increaseFontSize();
            }
        });

        zoomOut = new JButton("-");
        zoomOut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                decreaseFontSize();
            }
        });

        viewEval = new JButton("View Another Evaluation");
        viewEval.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                getevalIndex();
                evalField.setText(temp.displayEvals(evalIndex));
            }
        });

        addEval = new JButton("Add Evaluation");
        addEval.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                addEvals();
            }
        });
    
       JPanel buttons = new JPanel(new FlowLayout());
       buttons.add(viewEval);
       buttons.add(addEval);
       buttons.add(upEval);
       buttons.add(delEval);
       buttons.add(closeEval);
       buttons.add(zoomIn);
       buttons.add(zoomOut);

        evalField.setBackground(Color.GRAY);
        frame.getContentPane().add(buttons, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        evalField.setSelectedTextColor(Color.BLUE);

        
    }

private void increaseFontSize() 
    {
        Font currentFont = evalField.getFont();
        int newSize = currentFont.getSize() + 2; // Increase font size by 2 points
        Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), newSize);
        evalField.setFont(newFont);
    }

private void decreaseFontSize() 
    {
        Font currentFont = evalField.getFont();
        int newSize = currentFont.getSize() - 2; // Increase font size by 2 points
        Font newFont = new Font(currentFont.getFontName(), currentFont.getStyle(), newSize);
        evalField.setFont(newFont);
    }

private void updateEvaluation(Object n)
{
    if (n instanceof Evaluation) 
    {
        Evaluation eval = (Evaluation) n;
        
        String evalPerson = JOptionPane.showInputDialog(this, "Enter the person Evaluating:", eval.getEvaluator());
        String evalDate = JOptionPane.showInputDialog(this, "Enter the date of the Evaluation:", eval.getevalDate());
        String Ans1 = JOptionPane.showInputDialog(this,"Enter the answer to Question 1:", eval.geta1());
        String Ans2 = JOptionPane.showInputDialog(this,"Enter the answer to Question 2:", eval.geta2());
        String Ans3 = JOptionPane.showInputDialog(this,"Enter the answer to Question 3:", eval.geta3());

        // Update the object with new values
        eval.setevaluator(evalPerson);
        eval.setevalDate(evalDate);
        eval.seta1(Ans1);
        eval.seta2(Ans2);
        eval.seta3(Ans3);

        evalField.setText(eval.toString());
    }
}

private void deleteEvaluations(int index)
{
    TEMPARRAYS temp = new TEMPARRAYS();
    temp.deleteEval(index);
    evalField.setText("There is no evaluation for this employee");
}

public void displayEvalGUI()
{
    TEMPARRAYS temp = new TEMPARRAYS();
    String result = temp.displayEvals(evalIndex);
    evalField.setText(result);

}

private void addEvals() 
{
    String evalp = JOptionPane.showInputDialog("Enter the name of the Evaulator:");
    String time = JOptionPane.showInputDialog("Enter date of the Evaluation:");
    String ans1 = JOptionPane.showInputDialog("Enter the answer to Question 1:");
    String ans2 = JOptionPane.showInputDialog("Enter the answer to Question 2:");
    String ans3 = JOptionPane.showInputDialog("Enter the answer to Question 3:");

    if (evalp != null && time != null && ans1 != null && ans2 != null && ans3 != null) {
        TEMPARRAYS temp = new TEMPARRAYS();
        temp.addEvals(evalp, time, ans1, ans2, ans3);
        JOptionPane.showMessageDialog(null, "Evaluation added successfully.");
    } else {
        JOptionPane.showMessageDialog(null, "Please fill in all fields.");
    }
}

public void getevalIndex() 
{
    String userInput = JOptionPane.showInputDialog(null, "Enter the number of the employee you want to view");
    int newIndex = 0; // Default value if parsing fails or user cancels
    try {
        newIndex = Integer.parseInt(userInput);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
         getevalIndex();
    } catch (NullPointerException e) {
       
        JOptionPane.showMessageDialog(null, "Canceled.");
        
    }
    evalIndex = newIndex-1;
}
public static void main(String[] args) 
{
    SwingUtilities.invokeLater(() -> {
       EvalsGUI gui = new EvalsGUI();
    });
}
}
