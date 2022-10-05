//Dan Imbimbo - COMS115 (Chapter 12 #6)
import javax.swing.*;

public class GreetingsPanel extends JPanel{
    private JLabel greeting;
    
    public GreetingsPanel(){
        greeting = new JLabel("Welcome to Joe's Automotive");
        
        add(greeting);
    }
}
