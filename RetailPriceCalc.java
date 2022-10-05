//Dan Imbimbo - COMS115 (Chapter 12 #1)
import javax.swing.*; // Needed for Swing classes
import java.awt.event.*; // Needed for ActionListener Interface

public class RetailPriceCalc extends JFrame{
    private JPanel panel;
    private JLabel costLabel;
    private JLabel markUpLabel;
    private JTextField costTextField;
    private JTextField markUpTextField;
    private JButton calcButton;
    private final int WINDOW_WIDTH = 335;
    private final int WINDOW_HEIGHT = 135;
    
    public RetailPriceCalc(){
        setTitle("Retail Price Calculator");
        
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createPanel();
        
        add(panel);
        
        setVisible(true);
    }
    
    private void createPanel(){
        costLabel = new JLabel("Enter the cost($)");
        markUpLabel = new JLabel("Enter the mark up percentage(%)");
        
        costTextField = new JTextField(10);
        markUpTextField = new JTextField(10);
        
        calcButton = new JButton("Calculate");
        
        calcButton.addActionListener(new CalcButtonListener());
        
        panel = new JPanel();
        
        panel.add(costLabel);
        panel.add(costTextField);
        panel.add(markUpLabel);
        panel.add(markUpTextField);
        panel.add(calcButton);
    }
    
    private class CalcButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String costInput;
            String markUpInput;
            double cost;
            double markUp;
            double retailPrice;
            final double DECIMAL = .01;
            
            costInput = costTextField.getText();
            markUpInput = markUpTextField.getText();
            
            cost = Double.parseDouble(costInput);
            markUp = Double.parseDouble(markUpInput) * DECIMAL;
            
            retailPrice = cost + (cost * markUp);
            
            JOptionPane.showMessageDialog(null, "Retail Price: " + 
                    String.format("$%.2f", retailPrice));
        }
    }
    
    public static void main(String args[]){
        RetailPriceCalc priceCalc = new RetailPriceCalc();
    }
}
