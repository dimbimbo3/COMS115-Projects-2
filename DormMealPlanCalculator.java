import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class DormMealPlanCalculator extends JFrame{
    private JPanel dormPanel;
    private JPanel mealPanel;
    private JPanel buttonPanel;
    private JList dormList;
    private JScrollPane scrollPane;
    private JComboBox mealBox;
    private JButton calcButton;
    
    private String[] dorms = {"Allen Hall - $1500", "Pike Hall - $1600",
        "Farthing Hall - $1200", "University Suites - $1800"};
    private int[] dormCost = {1500, 1600, 1200, 1800};
    private int dormIndex = 0;
    
    private String[] meals = {"7 meals per week - $560", "14 meals per week - $1095",
        "Unlimited meals - $1500"};
    private int[] mealCost = {560, 1095, 1500};
    private int mealIndex = 0;
    
    private int total;
    
    public DormMealPlanCalculator(){
        setTitle("Dorm & Meal Plan Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        buildDormPanel();
        add(dormPanel, BorderLayout.CENTER);
        
        buildMealPanel();
        add(mealPanel, BorderLayout.EAST);
        
        buildButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    public void buildDormPanel(){
        dormPanel = new JPanel();
        dormPanel.setBorder(BorderFactory.createTitledBorder("Dormitories"));
        
        dormList = new JList(dorms);
        dormList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dormList.setSelectedIndex(0);//automatically highlights first item in list
        dormList.setVisibleRowCount(2);
        dormList.addListSelectionListener(new ListListener());
        
        scrollPane = new JScrollPane(dormList);
        
        dormPanel.add(scrollPane);
    }
    
    public void buildMealPanel(){
        mealPanel = new JPanel();
        mealPanel.setBorder(BorderFactory.createTitledBorder("Meal Plans"));
        
        mealBox = new JComboBox(meals);
        mealBox.addActionListener(new BoxButtonListener());
        
        mealPanel.add(mealBox);
    }
    
    public void buildButtonPanel(){
        buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Total"));
        
        calcButton = new JButton("Calculate");
        calcButton.addActionListener(new BoxButtonListener());
        
        buttonPanel.add(calcButton);
    }
    
    private class ListListener implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent e){
            dormIndex = dormList.getSelectedIndex();
        }
    }    
    
    private class BoxButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == mealBox){
                mealIndex = mealBox.getSelectedIndex();
            }
            if(e.getSource() == calcButton){
                total = dormCost[dormIndex] + mealCost[mealIndex];
                
                JOptionPane.showMessageDialog(null, "Selected Dorm Total (per semester): $" + 
                        dormCost[dormIndex] + "\nSelected Meal Plan Total (per semester): $" + 
                        mealCost[mealIndex] + "\nTotal: $" + total);
            }
        }
    }
    
    public static void main(String[] args){
        new DormMealPlanCalculator();
    }
}
