//Dan Imbimbo - COMS115 (Chapter 12 #10)
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CelsiusToFahrenheit extends JFrame{
    private JPanel radioPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JPanel bannerPanel;
    private JRadioButton celsius;
    private JRadioButton fahrenheit;
    private ButtonGroup radioButtonGroup;
    private JLabel tempLabel;
    private JTextField tempTextField;
    private JButton calcButton;
    private JLabel bannerLabel;
    
    public CelsiusToFahrenheit(){
        setTitle("Temperature Convertor");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        createRadioPanel();
        add(radioPanel, BorderLayout.WEST);
        
        createTextPanel();
        add(textPanel, BorderLayout.EAST);
        
        createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        createBannerPanel();
        add(bannerPanel, BorderLayout.NORTH);
        
        pack();
        setVisible(true);
    }
    
    private void createRadioPanel(){
        radioPanel = new JPanel(new GridLayout(2,1));
        
        celsius = new JRadioButton("Convert to Celsius");
        fahrenheit = new JRadioButton("Convert to Fahrenheit");
        
        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(celsius);
        radioButtonGroup.add(fahrenheit);
        
        radioPanel.add(celsius);
        radioPanel.add(fahrenheit);
    }
    
    private void createTextPanel(){
        textPanel = new JPanel();
        
        tempLabel = new JLabel("Enter temperature:");
        tempTextField = new JTextField(10);
        
        textPanel.add(tempLabel);
        textPanel.add(tempTextField);
    }
    
    private void createButtonPanel(){
        buttonPanel = new JPanel();
        
        calcButton = new JButton("Calculate");
        
        calcButton.addActionListener(new ButtonListener());
        
        buttonPanel.add(calcButton);
    }
    
    private void createBannerPanel(){
        bannerPanel = new JPanel();
        
        bannerLabel = new JLabel("Temp Conversion");
        
        bannerPanel.add(bannerLabel);
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String tempInput;
            double temp;
            double converted;
            
            tempInput = tempTextField.getText();
            if(tempInput.isEmpty()) //check for empty string
                tempInput = "0";
            
            temp = Double.parseDouble(tempInput);
            
            if(celsius.isSelected()){
                converted = (temp - 32) * (5/9.0);
                JOptionPane.showMessageDialog(null, temp + " Fahrenheit is " + converted + " Celcius");
            }
            if(fahrenheit.isSelected()){
                converted = ((9/5.0) * temp) + 32;
                JOptionPane.showMessageDialog(null, temp + " Celcius is " + converted + " fahrenheit");
            }
        }
    }
    
    public static void main(String args[]){
        new CelsiusToFahrenheit();
    }
}
