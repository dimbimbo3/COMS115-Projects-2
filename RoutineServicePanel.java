//Dan Imbimbo - COMS115 (Chapter 12 #6)
import javax.swing.*;
import java.awt.*;

public class RoutineServicePanel extends JPanel{
    private final double OIL_CHANGE = 26.00;
    private final double LUBE_JOB = 18.00;
    private final double RADIATOR_FLUSH = 30.00;
    private final double TRANSMISSION_FLUSH = 80.00;
    private final double INSPECTION = 15.00;
    private final double MUFFLER_REPLACEMENT = 100.00;
    private final double TIRE_ROTATION = 20.00;
    
    private JCheckBox oilChange;
    private JCheckBox lubeJob;
    private JCheckBox radiatorFlush;
    private JCheckBox transmissionFlush;
    private JCheckBox inspection;
    private JCheckBox mufflerReplacement;
    private JCheckBox tireRotation;
    
    public RoutineServicePanel(){
        setLayout(new GridLayout(7,1));
        setBorder(BorderFactory.createTitledBorder("Routine Services"));
        
        oilChange = new JCheckBox("Oil Change - $26");
        lubeJob = new JCheckBox("Lube Job - $18");
        radiatorFlush = new JCheckBox("Radiator Flush - $30");
        transmissionFlush = new JCheckBox("Transmission Flush - $80");
        inspection = new JCheckBox("Inspection - $15");
        mufflerReplacement = new JCheckBox("Muffler Replacement - $100");
        tireRotation = new JCheckBox("Tire Rotation - $20");
        
        add(oilChange);
        add(lubeJob);
        add(radiatorFlush);
        add(transmissionFlush);
        add(inspection);
        add(mufflerReplacement);
        add(tireRotation);
    }
    
    public double getServiceCost(){
        double cost = 0;
        
        if(oilChange.isSelected())
            cost += OIL_CHANGE;
        if(lubeJob.isSelected())
            cost += LUBE_JOB;
        if(radiatorFlush.isSelected())
            cost += RADIATOR_FLUSH;
        if(transmissionFlush.isSelected())
            cost += TRANSMISSION_FLUSH;
        if(inspection.isSelected())
            cost += INSPECTION;
        if(mufflerReplacement.isSelected())
            cost += MUFFLER_REPLACEMENT;
        if(tireRotation.isSelected())
            cost += TIRE_ROTATION;
        
        return cost;
    }
}
