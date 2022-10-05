//Dan Imbimbo - COMS115 (Chapter 12 #6)
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JoesAutomotive extends JFrame{
    private GreetingsPanel greetings;
    private RoutineServicePanel routine;
    private NonRoutineServicePanel nonRoutine;
    private JPanel buttonPanel;
    private JButton calcButton;
    private JButton exitButton;
    
    public JoesAutomotive(){
        setTitle("Joe's Automotive");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        greetings = new GreetingsPanel();
        routine = new RoutineServicePanel();
        nonRoutine = new NonRoutineServicePanel();
        
        createButtonPanel();
        
        add(greetings, BorderLayout.NORTH);
        add(routine, BorderLayout.WEST);
        add(nonRoutine, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack(); //Pack the contents of the window
        setVisible(true);
    }
    
    private void createButtonPanel(){
        buttonPanel = new JPanel();
        
        calcButton = new JButton("Calculate");
        exitButton = new JButton ("Exit");
        
        calcButton.addActionListener(new ButtonListener());
        exitButton.addActionListener(new ButtonListener());
        
        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == calcButton){
                double routineCost = routine.getServiceCost();
                double nonRoutineCost = nonRoutine.getServiceCost();
                double total = routineCost + nonRoutineCost;
                
                JOptionPane.showMessageDialog(null, "Routine Service Cost: $" +
                        String.format("%.2f", routineCost) + "\nNonroutine Service Cost: $" +
                        String.format("%.2f", nonRoutineCost) + "\n\nTotal Cost: $" +
                        String.format("%.2f", total));
            }
            else if(e.getSource() == exitButton)
                System.exit(0);
        }
    }
        
    
    public static void main(String args[]){
        new JoesAutomotive();
    }
}
