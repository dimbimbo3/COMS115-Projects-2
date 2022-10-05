import java.util.Scanner;

public class ProductionWorkerDriver {
    public static void main(String[] args){
        String name;
        String ID;
        String hireDate;
        int shift;
        double payRate;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Please enter the Employee Name:");
        name = keyboard.nextLine();
        
        do{
            System.out.print("\nPlease enter the Employee ID(Format: XXX-L)" +
                    "\n(Each X must be between 0-9" + " and L must be within A-M):");
            ID = keyboard.nextLine().toUpperCase();
        }while(!idCheck(ID));
        
        System.out.print("\nPlease enter the Employee Hire Date:");
        hireDate = keyboard.nextLine();
        
        do{
        System.out.print("\nPlease enter the Shift worked " + 
                "(type 1 for Day or 2 for Night):");
        shift = keyboard.nextInt();
        keyboard.nextLine(); //clear newline
        
        if(shift != 1 && shift != 2)
            System.out.println("Invalid Shift entered!");
        }while(shift != 1 && shift != 2);
        
        System.out.print("\nPlease enter the Hourly Pay Rate:");
        payRate = keyboard.nextDouble();
        keyboard.nextLine(); //clear newline
        
        ProductionWorker worker1 = new ProductionWorker(name, ID, hireDate, shift, payRate);
        
        System.out.println("");
        System.out.println(worker1);
    }
    
    public static boolean idCheck(String ID){
        boolean valid = true;
        final int ID_LENGTH = 5;
        
        if(ID.length() != ID_LENGTH)
            valid = false;
        else if(!Character.isDigit(ID.charAt(0))
                || !Character.isDigit(ID.charAt(1))
                || !Character.isDigit(ID.charAt(2))
                || ID.charAt(3) != '-'
                || !(ID.charAt(4) >= 'A' && ID.charAt(4) <= 'M'))
            valid = false;
            
        if(!valid)
            System.out.println("Invalid Employee ID entered!");    
        
        return valid;
    }
}
