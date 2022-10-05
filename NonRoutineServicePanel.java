//Dan Imbimbo - COMS115 (Chapter 12 #6)
import javax.swing.*;
import java.awt.*;

public class NonRoutineServicePanel extends JPanel{
    private final double PER_HOUR = 20.00;
    
    private JLabel partsLabel;
    private JLabel hoursLabel;
    private JTextField partsTextField;
    private JTextField hoursTextField;
    
    public NonRoutineServicePanel(){
        setBorder(BorderFactory.createTitledBorder("Nonroutine Services"));
        
        JPanel labels = new JPanel(new GridLayout(2,1));
        JPanel fields = new JPanel(new GridLayout(2,1));
        
        partsLabel = new JLabel("Enter cost of parts:");
        hoursLabel = new JLabel("Enter hours of labor:");
        
        labels.add(partsLabel);
        labels.add(hoursLabel);
        
        partsTextField = new JTextField(10);
        hoursTextField = new JTextField(10);
        
        fields.add(partsTextField);
        fields.add(hoursTextField);
        
        add(labels);
        add(fields);
    }
    
    public double getServiceCost(){
        String partsInput;
        String hoursInput;
        double parts;
        double hours;
        double cost;
        
        partsInput = partsTextField.getText();
        if(partsInput.isEmpty()) //check for empty string
            partsInput = "0";
        
        hoursInput = hoursTextField.getText();
        if(hoursInput.isEmpty()) //check for empty string
            hoursInput = "0";
        
        parts = Double.parseDouble(partsInput);
        hours = Double.parseDouble(hoursInput);
        
        cost = parts + (hours * PER_HOUR);
        
        return cost;
    }
}
