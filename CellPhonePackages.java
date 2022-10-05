import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CellPhonePackages extends JFrame{
    private JMenuBar menuBar;
    private JMenu phoneMenu;
    private JRadioButtonMenuItem packageItem1;
    private JRadioButtonMenuItem packageItem2;
    private JRadioButtonMenuItem packageItem3;
    private JRadioButtonMenuItem modelItem1;
    private JRadioButtonMenuItem modelItem2;
    private JRadioButtonMenuItem modelItem3;
    private JCheckBoxMenuItem voiceMailItem;
    private JCheckBoxMenuItem textMessageItem;
    private JLabel packagePriceLabel;
    private JLabel modelPriceLabel;
    private JLabel extrasPriceLabel;
    private JTextField packagePriceTextField;
    private JTextField modelPriceTextField;
    private JTextField extrasPriceTextField;
    private JPanel pricePanel;
    private JButton calcButton;
    
    private final double TAX_RATE = .06;
    private double modelPrice1 = 29.95 + (29.95 * TAX_RATE);
    private double modelPrice2 = 49.95 + (49.95 * TAX_RATE);
    private double modelPrice3 = 99.95 + (99.95 * TAX_RATE);
    
    public CellPhonePackages(){
        setTitle("Cell Phone Packages");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buildMenuBar();
        buildPricePanel();
        
        add(pricePanel);
        
        pack();
        setVisible(true);
    }
    
    public void buildMenuBar(){
        menuBar = new JMenuBar();
        
        buildPhoneMenu();
        
        menuBar.add(phoneMenu);
        
        setJMenuBar(menuBar);
    }
    
    public void buildPhoneMenu(){
        phoneMenu = new JMenu("Phone");
        phoneMenu.setMnemonic(KeyEvent.VK_P);
        
        packageItem1 = new JRadioButtonMenuItem("300 minutes per month: $45.00 per month");
        packageItem1.addActionListener(new PackageListener());
        packageItem2 = new JRadioButtonMenuItem("800 minutes per month: $65.00 per month");
        packageItem2.addActionListener(new PackageListener());
        packageItem3 = new JRadioButtonMenuItem("1500 minutes per month: $99.00 per month");
        packageItem3.addActionListener(new PackageListener());
        modelItem1 = new JRadioButtonMenuItem("Model 100: $29.95 (6% tax)");
        modelItem1.addActionListener(new ModelListener());
        modelItem2 = new JRadioButtonMenuItem("Model 110: $49.95 (6% tax)");
        modelItem2.addActionListener(new ModelListener());
        modelItem3 = new JRadioButtonMenuItem("Model 200: $99.95 (6% tax)");
        modelItem3.addActionListener(new ModelListener());
        voiceMailItem = new JCheckBoxMenuItem("Voice mail: $5.00 per month");
        voiceMailItem.addActionListener(new ExtrasListener());
        textMessageItem = new JCheckBoxMenuItem("Text messaging: $10.00 per month");
        textMessageItem.addActionListener(new ExtrasListener());
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(packageItem1);
        group1.add(packageItem2);
        group1.add(packageItem3);
        group1.clearSelection();
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(modelItem1);
        group2.add(modelItem2);
        group2.add(modelItem3);
        group2.clearSelection();
        
        phoneMenu.add(packageItem1);
        phoneMenu.add(packageItem2);
        phoneMenu.add(packageItem3);
        phoneMenu.addSeparator();
        phoneMenu.add(modelItem1);
        phoneMenu.add(modelItem2);
        phoneMenu.add(modelItem3);
        phoneMenu.addSeparator();
        phoneMenu.add(voiceMailItem);
        phoneMenu.add(textMessageItem);
    }
    
    public void buildPricePanel(){
        pricePanel = new JPanel();
        pricePanel.setLayout(new GridLayout(4,2));
        
        packagePriceLabel = new JLabel("Package Price ($):");
        packagePriceTextField = new JTextField("0.00");
        packagePriceTextField.setEditable(false);
        
        modelPriceLabel = new JLabel("Model Price ($):");
        modelPriceTextField = new JTextField("0.00");
        modelPriceTextField.setEditable(false);
        
        extrasPriceLabel = new JLabel("Extras Price ($):");
        extrasPriceTextField = new JTextField("0.00");
        extrasPriceTextField.setEditable(false);
        
        calcButton = new JButton("Calculate Total");
        calcButton.addActionListener(new ButtonListener());
        
        pricePanel.add(packagePriceLabel);
        pricePanel.add(packagePriceTextField);
        pricePanel.add(modelPriceLabel);
        pricePanel.add(modelPriceTextField);
        pricePanel.add(extrasPriceLabel);
        pricePanel.add(extrasPriceTextField);
        pricePanel.add(new JPanel());//empty panel for grid layout
        pricePanel.add(calcButton);
    }
    
    public class PackageListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(packageItem1.isSelected())
                packagePriceTextField.setText("45.00");
            else if(packageItem2.isSelected())
                packagePriceTextField.setText("65.00");
            else if(packageItem3.isSelected())
                packagePriceTextField.setText("99.00");
        }
    }
    
    public class ModelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(modelItem1.isSelected())
                modelPriceTextField.setText(String.format("%.2f", modelPrice1));
            else if(modelItem2.isSelected())
                modelPriceTextField.setText(String.format("%.2f", modelPrice2));
            else if(modelItem3.isSelected())
                modelPriceTextField.setText(String.format("%.2f", modelPrice3));
        }
    }
    
    public class ExtrasListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(voiceMailItem.isSelected() && !textMessageItem.isSelected())
                extrasPriceTextField.setText("5.00");
            else if(!voiceMailItem.isSelected() && textMessageItem.isSelected())
                extrasPriceTextField.setText("10.00");
            else if(voiceMailItem.isSelected() && textMessageItem.isSelected())
                extrasPriceTextField.setText("15.00");
            else
                extrasPriceTextField.setText("0.00");
        }
    }
    
    public class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            double total = Double.parseDouble(packagePriceTextField.getText()) + 
                    Double.parseDouble(modelPriceTextField.getText()) + 
                    Double.parseDouble(extrasPriceTextField.getText());
            JOptionPane.showMessageDialog(null, "Total Price: " + String.format("$%.2f", total));
        }
    }
    
    public static void main(String[] args){
        new CellPhonePackages();
    }
}
